package ticTacToe;


import javax.swing.JFrame;

public class GameMain {

	public static void main(String[] args){
		
		GameFrame frame = new GameFrame();
		frame.setTitle("Tic-Tac-Toe"); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		return;
		/*
		BoardPanel boardpanel = new BoardPanel();
		JFrame frame = new JFrame();
		frame.setSize(200, 200);
		frame.add(boardpanel);
		frame.setTitle("Tic-Tac-Toe"); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		*/
	}

}

