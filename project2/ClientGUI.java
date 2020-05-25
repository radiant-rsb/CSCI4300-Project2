package project2;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ClientGUI extends JFrame {
	public ClientGUI() {
		GameClient gc = new GameClient();
		GameServer server = new GameServer();
		
		this.setTitle("Project 2: Rock, Paper, Scissors");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    CardLayout cardLayout = new CardLayout();
	    JPanel container = new JPanel(cardLayout);
	    
	    InitialControl ic = new InitialControl(container); 
	    JoinServerControl jc = new JoinServerControl(container, gc);
	    CreateServerControl csc = new CreateServerControl(container, gc, server);
	    GameControl gcc = new GameControl(container, gc);
	    
	 // Create the four views. (need the controller to register with the Panels
	    JPanel view1 = new InitialPanel(ic);
	    JPanel view2 = new JoinServerPanel(jc);
	    JPanel view3 = new CreateServerPanel(csc);
	    JPanel view4 = new GamePanel(gcc);
	    
	    gc.setContainer((JPanel)view4);
	    
	    container.add(view1, "1");
	    container.add(view2, "2");
	    container.add(view3, "3");
	    container.add(view4, "4");
	    
	    cardLayout.show(container, "1");
	    this.add(container, BorderLayout.CENTER);
	    
	    gc.setContainer(container);

	    // Show the JFrame.
	    this.setSize(550, 350);
	    this.setVisible(true);
	}
	
	
	// Main function that creates the client GUI when the program is started.
	  public static void main(String[] args)
	  {
	    new ClientGUI();
	  }
}
