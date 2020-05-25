package project2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class JoinServerPanel extends JPanel {
	private JTextField ipField;
	private JTextField portField;
	
	public String getIp() {
		return ipField.getText();
	}
	
	public String getPort() {
		return portField.getText();
	}
	
	public JoinServerPanel(JoinServerControl jc) {
		
		JPanel joinPanel = new JPanel(new GridLayout(2, 2, 5, 5));
	    JLabel ipLabel = new JLabel("IP Address: ", JLabel.RIGHT);
	    ipField = new JTextField(15);
	    JLabel portLabel = new JLabel("Port No: ", JLabel.RIGHT);
	    portField = new JTextField(15);
	    joinPanel.add(ipLabel);
	    joinPanel.add(ipField);
	    joinPanel.add(portLabel);
	    joinPanel.add(portField);
	    
	 // Create a panel for the buttons.
	    JPanel buttonPanel = new JPanel();
	    JButton joinButton = new JButton("Join");
	    joinButton.addActionListener(jc);
	    JButton cancelButton = new JButton("Cancel");
	    cancelButton.addActionListener(jc);    
	    buttonPanel.add(joinButton);
	    buttonPanel.add(cancelButton);

	    // Arrange the three panels in a grid.
	    JPanel grid = new JPanel(new GridLayout(2, 1, 0, 10));
	    grid.add(joinPanel);
	    grid.add(buttonPanel);
	    this.add(grid);
	}
}
