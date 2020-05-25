package project2;

import java.io.Serializable;

public class GameData implements Serializable {
	private int playerNum;
	private String move;
	
	public GameData(int playerNum, String move) {
		this.playerNum = playerNum;
		this.move = move;
	}
	
	public GameData() {
		this.playerNum = 0;
		this.move = "INVALID MOVE";
	}
	
	public int getPlayerNum() {
		return playerNum;
	}
	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}
	public String getMove() {
		return move;
	}
	public void setMove(String move) {
		this.move = move;
	}
	
}
