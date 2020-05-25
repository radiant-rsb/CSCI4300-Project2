package project2;

import java.io.IOException;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

public class GameServer extends AbstractServer {

	private GameData player1 = null;
	private GameData player2 = null;
	private boolean gameStart = false;
	private String result;

	public GameServer() {
		super(12345);
		this.setTimeout(500);
	}

	public GameServer(int port, int timeout) {
		super(port);
		this.setTimeout(timeout);
	}

	protected void handleMessageFromClient(Object arg0, ConnectionToClient arg1) {
		if (arg0 instanceof GameData) {
			GameData data = (GameData) arg0;
			
			if (data.getPlayerNum() == 1) {
				player1 = data;
			} else if (data.getPlayerNum() == 2) {
				player2 = data;
			}
			
			if (player1 != null && player2 != null && this.getNumberOfClients() == 2)
				gameStart = true;

			if (gameStart) {
				// Game Logic
				if (player1.getMove().equals("Paper") && player2.getMove().equals("Rock"))
					result = "Player1 wins";
				else if (player1.getMove().equals("Rock") && player2.getMove().equals("Paper"))
					result = "Player2 wins";
				else if (player1.getMove().equals("Rock") && player2.getMove().equals("Scissors"))
					result = "Player1 wins";
				else if (player1.getMove().equals("Scissors") && player2.getMove().equals("Rock"))
					result = "Player2 wins";
				else if (player1.getMove().equals("Scissors") && player2.getMove().equals("Paper"))
					result = "Player1 wins";
				else if (player1.getMove().equals("Paper") && player2.getMove().equals("Scissors"))
					result = "Player2 wins";
				else
					result = "Draw";

				Thread[] connections = this.getClientConnections();
				if (connections.length == 2) {
					ConnectionToClient client1 = (ConnectionToClient) connections[0];
					ConnectionToClient client2 = (ConnectionToClient) connections[1];
					
					try {
						client1.sendToClient(result);
						client2.sendToClient(result);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
				
				gameStart = false;
				player1 = null;
				player2 = null;
			}
		}

		

		if (arg0 instanceof String) {
			if (arg0 == "quit") {
				System.out.println("A client has disconnected");
			}
		}

	}


	protected void clientConnected(ConnectionToClient arg1) {
		Integer playernum = this.getNumberOfClients();
		try {
			arg1.sendToClient(playernum);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
