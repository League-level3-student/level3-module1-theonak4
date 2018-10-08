package _04_HangMan;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JLabel label2 = new JLabel();
	JLabel lives = new JLabel();
	int livesCount = 10;
	String displayString, actualWord, letterList;
	ArrayList<Character> guessedLetters = new ArrayList<Character>();

	void reloadDisplay() {
		displayString = "";
		for (int i = 0; i < actualWord.length(); i++) {
			displayString += "_";
		}
		char[] r = displayString.toCharArray();
		for (int i = 0; i < guessedLetters.size(); i++) {
			for (int j = 0; j < actualWord.length(); j++) {
				if (actualWord.charAt(j) == guessedLetters.get(i)) {
					r[j] = guessedLetters.get(i);
				}
			}
		}
		
		displayString = "";
		for (int i = 0; i < r.length; i++) {
			displayString += r[i];
		}
		letterList = "";
		for (Character i : guessedLetters) {
			boolean has = false;
			for (int j = 0; j < r.length; j++) {
				if (r[j] == i)
					has = true;
			}
			if (!has) {
				letterList += i;
			}
		}

		label.setText(displayString);
		label2.setText(letterList);
		livesCount = 10 - letterList.length();
		lives.setText(livesCount+"");
		frame.pack();
		if(livesCount < 1) {
			JOptionPane.showMessageDialog(null, "You lost. The word was "+actualWord+".");
			System.exit(0);
		}
	}

	void newWord() {
		frame.setVisible(false);
		actualWord = Utilities.readRandomLineFromFile("src/_04_HangMan/dictionary.txt");
		reloadDisplay();
		frame.setVisible(true);
	}

	public HangMan() {
		frame.add(panel);
		panel.add(label);
		panel.add(label2);
		panel.add(lives);
		frame.addKeyListener(this);
		label.setText(displayString);
	}

	void start() {
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label2.setForeground(Color.RED);
		lives.setForeground(Color.BLUE);
		frame.setVisible(true);
		newWord();
	}

	public static void main(String[] args) {
		new HangMan().start();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (!guessedLetters.contains(e.getKeyChar())) {
			guessedLetters.add(e.getKeyChar());
			System.out.println("typed");
		}

		reloadDisplay();
		
		if(!displayString.contains("_")) {
			JOptionPane.showMessageDialog(null, "You won!");
			System.exit(0);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}