package _04_HangMan;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HangMan implements KeyListener {
	public static void main(String[] args) {
		HangMan hang = new HangMan();
		
		String Num = JOptionPane.showInputDialog("Choose A Number From 1 To 266");
		int num = Integer.parseInt(Num);
		Stack<String> stack = new Stack<String>();
	
		for (int i = 0; i < num; i++) {
			String words = Utilities.readRandomLineFromFile(filename);
			if (stack.contains(words)) {
				i--;
			} else {
				stack.push(words);
			}
	
		}
		System.out.println(stack);
		last = stack.pop();
		cha = last.length();
		System.out.println(last);
		System.out.println(cha);
		hang.stuff();
	
	}
	static String filename = "src/_04_HangMan/dictionary.txt";
	JFrame frame = new JFrame();
	JLabel label = new JLabel();
	public int lifes = 10;
	JLabel lives = new JLabel();
	JPanel panel = new JPanel();
	static String last = "";
	static int cha;
	public void stuff() {
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.addKeyListener(this);
		panel.add(label);
		panel.add(lives);
		label.setVisible(true);
		String blanks = "";
		for (int i = 0; i < cha; i++) {
			blanks += " __ ";
		}
		label.setFont(new Font("Serif", Font.PLAIN,20));
		label.setText(blanks);
		
		lives.setText("       You Have " + lifes + " Lives");
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char c = e.getKeyChar();
		boolean right = false;
		
		for (int i = 0; i < cha; i++) {
		
			if (last.charAt(i)==c) {
				label.setText(Character.toString(c));
				right = true;
			} 
			
		}
		
		if(!right) {
			lifes = lifes - 1;
			lives.setText("       You Have " + lifes + " Lives");
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
