package project2;

import ocsf.client.AbstractClient;
import java.io.IOException;
import javax.swing.JPanel;

public class GameClient extends AbstractClient {
	
	private JPanel container;
	private String host;
	private int port;
	private int playerNum = 0;
	private int player1Score = 0;
	private int player2Score = 0;
	
	public GameClient() {
		super("localhost",8300);
	}
	
	public void setContainer(JPanel view4) {
		  container = view4;
	  }
	
	public void resetScores() {
		player1Score = 0;
		player2Score = 0;
	}
	
	public int getPlayerNum() {
		return playerNum;
	}
	
	public void setPlayerNum(int num) {
		playerNum = num;
	}

	protected void handleMessageFromServer(Object arg0) {
		if (arg0 instanceof Integer) {
			if (playerNum == 0)
				playerNum = ((Integer) arg0).intValue();
		}
		
		else if (arg0 instanceof String) {
			GamePanel gamePanel = (GamePanel)container.getComponent(3);
			if (arg0.equals("Draw")) {
				gamePanel.setStatus("Draw!");
				gamePanel.setScore1(Integer.toString(player1Score));
				gamePanel.setScore2(Integer.toString(player2Score));
			}
			else if (arg0.equals("Player1 wins")) {
				gamePanel.setStatus("Player 1 wins!");
				player1Score++;
				gamePanel.setScore1(Integer.toString(player1Score));
				gamePanel.setScore2(Integer.toString(player2Score));
			}
			else if (arg0.equals("Player2 wins")) {
				gamePanel.setStatus("Player 2 wins!");
				player2Score++;
				gamePanel.setScore1(Integer.toString(player1Score));
				gamePanel.setScore2(Integer.toString(player2Score));
			}
		}
		
		
		
	}
}
