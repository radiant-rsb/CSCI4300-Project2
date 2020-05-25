package project2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class GameControl implements ActionListener {
	private JPanel container;
	private GameClient client;
	private GameData data;
	
	public GameControl(JPanel container, GameClient client) {
		this.container = container;
		this.client = client;
		data = new GameData();
	}
	
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		
		if (!client.isConnected()) {
			try {
				client.setHost(client.getHost());
				client.setPort(client.getPort());
				client.openConnection();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (command == "Rock") {
			data.setMove("Rock");
			data.setPlayerNum(client.getPlayerNum());
			try {
				client.sendToServer(data);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if (command == "Paper") {
			data.setMove("Paper");
			data.setPlayerNum(client.getPlayerNum());
			try {
				client.sendToServer(data);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if (command == "Scissors") {
			data.setMove("Scissors");
			data.setPlayerNum(client.getPlayerNum());
			try {
				client.sendToServer(data);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
