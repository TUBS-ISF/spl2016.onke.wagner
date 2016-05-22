import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUI extends JFrame {
	JTextArea nameTextfield;
	JTextArea typeTextfield;
	private static final String placeholder = "Select a pattern";

	public GUI(List<DesignPatternInformation> informations) {
		super("Design Pattern Learner");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new FlowLayout());

		// #ifdef ListAllPatterns
		JComboBox<String> combo1 = new JComboBox<String>();
		for (int i = 0; i < informations.size(); i++) {
			if (i == 0) {
				combo1.addItem(placeholder);
			}
			combo1.addItem(informations.get(i).getName());
		}
		combo1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selected = combo1.getSelectedItem().toString();
				if (selected.equals(placeholder)) {
					//#ifdef Name
					nameTextfield.setText("");
					//#endif
					//#ifdef Type
					typeTextfield.setText("");
					//#endif
				} else {
					for (DesignPatternInformation information : informations) {
						if (information.getName().equals(selected)) {
							// #ifdef Name
							setNameTextfield(information.getName());
							// #endif
							// #ifdef Type
							setTypeTextfield(information.getType());
							// #endif
							break;
						}
					}
				}
			}
		});
		getContentPane().add(combo1);
		// #endif
		// #ifdef Name
		nameTextfield = new JTextArea(1, 20);
		nameTextfield.setLineWrap(true);
		nameTextfield.setWrapStyleWord(true);
		nameTextfield.setEditable(false);
		JScrollPane scrollpaneName = new JScrollPane(nameTextfield);
		getContentPane().add(scrollpaneName);
		// #endif
		// #ifdef Type
		typeTextfield = new JTextArea(1, 20);
		typeTextfield.setLineWrap(true);
		typeTextfield.setWrapStyleWord(true);
		typeTextfield.setEditable(false);
		JScrollPane scrollpaneType = new JScrollPane(typeTextfield);
		getContentPane().add(scrollpaneType);
		// #endif
		setLocation(250, 190);
		setSize(300, 150);
		setVisible(true);
	}

	private void setNameTextfield(String text) {
		nameTextfield.setText("Name: " + text);
	}

	private void setTypeTextfield(String text) {
		typeTextfield.setText("Type: " + text);
	}
}
