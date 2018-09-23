package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	JLabel label;
	Stack<Character> deleted;
	
	public _02_TextUndoRedo() {
		deleted = new Stack<>();
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		label = new JLabel("");
		panel.add(label);
		frame.add(panel);
		frame.addKeyListener(this);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new _02_TextUndoRedo();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stu
		label.setText(label.getText() + e.getKeyChar());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
		  deleted.push('a');
		 label.setText(label.getText().substring(0, label.getText().length()-2));
		}


		if(e.getKeyCode() == KeyEvent.VK_SHIFT) {
			System.out.println(deleted.size());
			Character s = deleted.pop();
			System.out.println(s);
			label.setText(label.getText() + Character.toString(s));
		
		
	}
	}
}