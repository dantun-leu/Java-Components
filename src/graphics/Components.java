package graphics;

// The "Components" class.
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Components extends JFrame implements ActionListener, ItemListener,
		ListSelectionListener {
	// Declare objects
	JLabel label;
	JButton button1, button2;
	JTextField text;
	JRadioButton radio1, radio2;
	JCheckBox chkbox1, chkbox2;
	JList<String> list;
	JComboBox<String> combo;

	public Components() {
		super("Components");

		// Set up the frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(300, 300, 200, 350);

		// Create objects
		JPanel outer = new JPanel(new BorderLayout());
		JPanel content = new JPanel();
		label = new JLabel("This is a label.", JLabel.CENTER);
		button1 = new JButton("Button1");
		button2 = new JButton("Button2");
		text = new JTextField(10);
		radio1 = new JRadioButton("Radio Button 1");
		radio2 = new JRadioButton("Radio Button 2");
		chkbox1 = new JCheckBox("CheckBox 1");
		chkbox2 = new JCheckBox("CheckBox 2");
		String[] listItems = { "Canada", "United States of America", "Mexico" };
		list = new JList<>(listItems);
		String[] comboItems = { "Bird", "Cat", "Dog", "Rabbit", "Komodo Dragon" };
		combo = new JComboBox<>(comboItems);
		combo.setEditable(true);

		// Group the radio buttons (so only one can be selected at a time)
		ButtonGroup group = new ButtonGroup();
		group.add(radio1);
		group.add(radio2);

		// Add contents
		outer.add(label, BorderLayout.NORTH);
		outer.add(content, BorderLayout.CENTER);
		content.add(button1);
		content.add(button2);
		content.add(text);
		content.add(radio1);
		content.add(radio2);
		content.add(chkbox1);
		content.add(chkbox2);
		content.add(list);
		content.add(combo);

		// Add listeners
		button1.addActionListener(this);
		button2.addActionListener(this);
		text.addActionListener(this);
		radio1.addActionListener(this);
		radio2.addActionListener(this);
		chkbox1.addItemListener(this);
		chkbox2.addItemListener(this);
		list.addListSelectionListener(this);
		combo.addActionListener(this);

		// Show the contents
		this.setContentPane(outer);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) {
			label.setText("Button 1 was pressed.");
		} else if (e.getSource() == button2) {
			label.setText("Button 2 was pressed.");
		} else if (e.getSource() == text) {
			label.setText("You typed: " + text.getText());
		} else if (e.getSource() == radio1) {
			label.setText("Radio Button 1 was pressed.");
		} else if (e.getSource() == radio2) {
			label.setText("Radio Button 2 was pressed.");
		} else if (e.getSource() == combo) {
			label.setText("Combo Item #" + (combo.getSelectedIndex() + 1) + ":"
					+ combo.getSelectedItem());
		}
	}

	public void itemStateChanged(ItemEvent e) {
		Object source = e.getSource();
		if (source == chkbox1) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				label.setText("CheckBox 1 was checked.");
			} else {
				label.setText("CheckBox 1 was unchecked.");
			}
		} else if (source == chkbox2) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				label.setText("CheckBox 2 was checked.");
			} else {
				label.setText("CheckBox 2 was unchecked.");
			}
		}
	}

	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource() == list) {
			label.setText("List Item #" + (list.getSelectedIndex() + 1) + ": "
					+ list.getSelectedValue());
		}
	}

	public static void main(String[] args) {
		new Components();
	} // main method
}