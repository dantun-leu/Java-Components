package graphics;

// The "Components" class.
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Components extends JFrame {
	// Declare objects
	JLabel label;
	JButton button1, button2;

	public Components() {
		super("Components");

		// Set up the frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(300, 300, 200, 350);

		// Show the contents
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Components();
	} // main method
}