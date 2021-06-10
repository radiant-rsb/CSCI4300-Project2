package project2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CreateServerPanel extends JPanel {
	private JTextField portField;
	private JTextField timeoutField;
	
	public String getPort() {
		return portField.getText();
	}
	
	public String getTimeout() {
		return timeoutField.getText();
	}
	
	public CreateServerPanel(CreateServerControl csc) {
		
	    JPanel createPanel = new JPanel(new GridLayout(2, 2, 5, 5));
	    JLabel portLabel = new JLabel("Port No: ", JLabel.RIGHT);
	    portField = new JTextField(15);
	    JLabel timeoutLabel = new JLabel("Timeout: ", JLabel.RIGHT);
	    timeoutField = new JTextField(15);
	    createPanel.add(portLabel);
	    createPanel.add(portField);
	    createPanel.add(timeoutLabel);
	    createPanel.add(timeoutField);
	    
	 // Create a panel for the buttons.
	    JPanel buttonPanel = new JPanel();
	    JButton createButton = new JButton("Create");
	    createButton.addActionListener(csc);
	    JButton cancelButton = new JButton("Cancel");
	    cancelButton.addActionListener(csc);    
	    buttonPanel.add(createButton);
	    buttonPanel.add(cancelButton);

	    // Arrange the three panels in a grid.
	    JPanel grid = new JPanel(new GridLayout(2, 1, 0, 10));
	    grid.add(createPanel);
	    grid.add(buttonPanel);
	    this.add(grid);
	}
}
