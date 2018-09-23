package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other
	// button reads "View Names".
	// When the add name button is clicked, display an input dialog that asks the
	// user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a
	// message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	ArrayList<String> names = new ArrayList<String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton();
	JButton button2 = new JButton();

	_02_GuestBook() {
		frame.add(panel);
		panel.add(button1);
		panel.add(button2);

		frame.setVisible(true);
		button1.setText("AddName");
		button2.setText("View Names");
		frame.pack();
		button1.addActionListener(this);
		button2.addActionListener(this);
	}

	public static void main(String[] args) {
		_02_GuestBook book = new _02_GuestBook();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();

		if (buttonPressed == button1) {
			String name = JOptionPane.showInputDialog("Add a name");
			names.add(name);
		}
		if (buttonPressed == button2) {
			String fullList = "";
			for (int i = 0; i < names.size(); i++) {
				String name = names.get(i);
				fullList += "Guest #" + (i + 1) + ": " + name + "\n";

			}
			JOptionPane.showMessageDialog(null, fullList);
		}

	}

}