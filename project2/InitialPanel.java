package project2;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InitialPanel extends JPanel {
	public InitialPanel(InitialControl ic)
	  {
	    // Create the controller.
	    //InitialControl controller = new InitialControl(container);
	    
	    // Create the information label.
	    JLabel label = new JLabel("Project 2: Rock, Paper, Scissors", JLabel.CENTER);
	    
	    // Create the join button.
	    JButton joinButton = new JButton("Join");
	    joinButton.addActionListener(ic);
	    JPanel joinButtonBuffer = new JPanel();
	    joinButtonBuffer.add(joinButton);
	    
	    // Create the create game button.
	    JButton createButton = new JButton("Create");
	    createButton.addActionListener(ic);
	    JPanel createButtonBuffer = new JPanel();
	    createButtonBuffer.add(createButton);

	    // Arrange the components in a grid.
	    JPanel grid = new JPanel(new GridLayout(3, 1, 5, 5));
	    grid.add(label);
	    grid.add(joinButtonBuffer);
	    grid.add(createButtonBuffer);
	    this.add(grid);
	  }
}
