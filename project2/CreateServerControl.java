package project2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.IOException;

public class CreateServerControl implements ActionListener {
	private JPanel container;
	private GameClient client;
	private CreateServerData data;
	private GameServer server;
	
	public CreateServerControl(JPanel container, GameClient client, GameServer server) {
		this.container = container;
		this.client = client;
		this.server = server;
	}
	
	public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
		
		if (command == "Cancel")
	    {
	      CardLayout cardLayout = (CardLayout)container.getLayout();
	      cardLayout.show(container, "1");
	    }
		else if (command == "Create") {
			CreateServerPanel createServerPanel = (CreateServerPanel)container.getComponent(2);
			CreateServerData data = new CreateServerData(Integer.parseInt(createServerPanel.getPort()), Integer.parseInt(createServerPanel.getTimeout()));
			
			server.setPort(data.getPort());
			server.setTimeout(data.getTimeout());
			
			try {
				server.listen();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			InetAddress ip;
			String address = "localhost";
			try {
				ip = InetAddress.getLocalHost();
				address = ip.getHostAddress();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			
			client.setHost(address);
			client.setPort(data.getPort());
			
			try {
				client.openConnection();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			while(server.isListening()) {
				if (server.getNumberOfClients() == 2) {
					CardLayout cardLayout = (CardLayout)container.getLayout();
				    cardLayout.show(container, "4");
				    break;
				}
			}
			
		}
	}
}
