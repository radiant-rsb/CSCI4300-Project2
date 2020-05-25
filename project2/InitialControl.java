package project2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class InitialControl implements ActionListener {
	// Private data field for storing the container.
	  private JPanel container;
	 
	  // Constructor for the initial controller.
	  public InitialControl(JPanel container)
	  {
	    this.container = container;
	   
	  }
	  
	  // Handle button clicks.
	  public void actionPerformed(ActionEvent ae)
	  {
	    // Get the name of the button clicked.
	    String command = ae.getActionCommand();
	    
	    // The Login button takes the user to the login panel.
	    if (command.equals("Join"))
	    {
	      //JoinServerPanel joinServerPanel = (JoinServerPanel) container.getComponent(2);
	      CardLayout cardLayout = (CardLayout)container.getLayout();
	      cardLayout.show(container, "2");
	     
	    }
	    
	    // The Create button takes the user to the create account panel.
	    else if (command.equals("Create"))
	    {
	      //CreateServerPanel createServerPanel = (CreateServerPanel)container.getComponent(3);
	      CardLayout cardLayout = (CardLayout)container.getLayout();
	      cardLayout.show(container, "3");
	    }
	  }
}
