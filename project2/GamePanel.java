package project2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GamePanel extends JPanel {
	
	private JLabel statusLabel;
	private JLabel score1;
	private JLabel score2;
	
	public void setStatus(String status) {
		statusLabel.setText(status);
	}
	
	public void setScore1(String score) {
		score1.setText(score);
	}
	
	public void setScore2(String score) {
		score2.setText(score);
	}
	
	public GamePanel(GameControl gc) {
		JPanel labelPanel = new JPanel(new GridLayout(2, 1, 5, 5));
	    statusLabel = new JLabel("", JLabel.CENTER);
	    statusLabel.setForeground(Color.GREEN);
	    JLabel titleLabel = new JLabel("Rock, Paper, Scissors", JLabel.CENTER);
	    labelPanel.add(titleLabel);
	    labelPanel.add(statusLabel);
	    
	    JPanel buttonPanel = new JPanel();
	    JButton rockButton = new JButton("Rock");
	    JButton paperButton = new JButton("Paper");
	    JButton scissorsButton = new JButton("Scissors");
	    rockButton.addActionListener(gc);
	    paperButton.addActionListener(gc);
	    scissorsButton.addActionListener(gc);
	    buttonPanel.add(rockButton);
	    buttonPanel.add(paperButton);
	    buttonPanel.add(scissorsButton);
	    
	    JPanel scorePanel = new JPanel(new GridLayout(2, 2, 5, 5));
	    JLabel header1 = new JLabel("Player 1: ", JLabel.LEFT);
	    score1 = new JLabel("", JLabel.CENTER);
	    JLabel header2 = new JLabel("Player 2: ", JLabel.LEFT);
	    score2 = new JLabel("", JLabel.CENTER);
	    scorePanel.add(header1);
	    scorePanel.add(score1);
	    scorePanel.add(header2);
	    scorePanel.add(score2);
	    
	    JPanel grid = new JPanel(new GridLayout(3, 1, 0, 10));
	    grid.add(labelPanel);
	    grid.add(buttonPanel);
	    grid.add(scorePanel);
		this.add(grid);
	}

}
