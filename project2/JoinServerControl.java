package project2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class JoinServerControl implements ActionListener {
	private JPanel container;
	private GameClient client;
	
	public JoinServerControl(JPanel container, GameClient client) {
		this.container = container;
		this.client = client;
	}
	
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		
		if (command == "Cancel")
	    {
	      CardLayout cardLayout = (CardLayout)container.getLayout();
	      cardLayout.show(container, "1");
	    }
		else if (command == "Join") {
			JoinServerPanel joinServerPanel = (JoinServerPanel)container.getComponent(1);
			JoinServerData data = new JoinServerData(joinServerPanel.getIp(), Integer.parseInt(joinServerPanel.getPort()));
			boolean success = false;
			
			//Input checking is largely going to be ignored for now for convenience
			client.setHost(data.getHost());
			client.setPort(data.getPort());
			
			try {
				client.openConnection();
				success = true;
			} catch (IOException e) {
				e.printStackTrace();
				success = false;
			} finally {
				if (success) {
					 CardLayout cardLayout = (CardLayout)container.getLayout();
					 cardLayout.show(container, "4");
				}
			}
		}
	}
}
