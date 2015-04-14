package graphics;

// The "Components" class.
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Components extends JFrame implements ActionListener {
	// Declare objects
	JLabel label;
	JButton button1, button2;
	JTextField text; 

	public Components() {
		super("Components");

		// Set up the frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(300, 300, 200, 350);

		// Create objects
		JPanel content = new JPanel();
		label = new JLabel("This is a label.", JLabel.CENTER);
		button1 = new JButton("Button1");
		button2 = new JButton("Button2");
		text = new JTextField (10); 

		// Add contents
		content.add(label);
		content.add(button1);
		content.add(button2);
		content.add (text);
		
		

		// Add listeners
		button1.addActionListener(this);
		button2.addActionListener(this);
		text.addActionListener (this); 
		

		// Show the contents
		this.setContentPane(content);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) {
			label.setText("Button 1 was pressed.");
		} else if (e.getSource() == button2) {
			label.setText("Button 2 was pressed.");
		}
		else if (e.getSource () == text)
		 {
		 label.setText ("You typed: " + text.getText ());
		 }
	}

	public static void main(String[] args) {
		new Components();
	} // main method
}