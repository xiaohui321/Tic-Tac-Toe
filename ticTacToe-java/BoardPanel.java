package ticTacToe;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BoardPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int STATUS_NEW_GAME      		= 20;
	public static final int STATUS_PLAYING       		= 21;
	public static final int STATUS_RESULT_DETERMINED	= 22;
	
	public static final int PANEL_HEIGHT = 300;
	public static final int PANEL_WIDTH  = 300;
	
	private int status;
	
	private Board theBoard;
	
	private JTextField textField;
	private JPanel buttonPanel;
	private JButton[][] buttons;

	private void AddButton(final int x, final int y)
	{
		class ButtonListener implements ActionListener
		  { 
			  public void actionPerformed(ActionEvent event)
			  { 
				  if (status == STATUS_NEW_GAME || status == STATUS_RESULT_DETERMINED)
					  return;
				  if(theBoard.CheckDotEmpty(x, y)  && !(theBoard.LockedStatus()) 
						  && status == STATUS_PLAYING)
				  {
					  theBoard.DotMove(Board.CHAR_HUMAN,x, y);
					  JButton buttona = (JButton) event.getSource();
					  buttona.setText("X");
					  CheckWinStatus();
					  if(status == STATUS_PLAYING)
					  {
						  ComputerMove();
						  CheckWinStatus();
					  }
				  }
				  else
					  textField.setText("INVALID MOVE!");
					  
			  }
		  }
		 JButton button = new JButton();
		 buttonPanel.add(button);
		 ActionListener listener = new ButtonListener();
		 button.addActionListener(listener);
		 buttons[x][y]=button;
	}

	public BoardPanel() 
	{
		status = STATUS_NEW_GAME;
		
		//construct
		theBoard = new Board();
		textField = new JTextField();
		buttonPanel = new JPanel();
		buttons = new JButton[3][3];
		//add
		setLayout(new BorderLayout());
		add(textField,"South");
		
		buttonPanel.setLayout(new GridLayout(3,3));	
		
		for(int x = 0; x<3; x++)
			for(int y = 0; y<3;y++)
				AddButton(x,y);

		add(buttonPanel);
		setSize(PANEL_HEIGHT,PANEL_WIDTH);
		textField.setText("Hi! Welcome to Tic-Tac-Toe Game! Do you want to Play first?");
	}
		
	public void Reset()
	{
		theBoard.Reset();
		textField.setText("This is a new game. Do you want to Play first?");
		status=STATUS_NEW_GAME;
		for(int x = 0; x<3; x++)
			for(int y = 0; y<3;y++)
				buttons[x][y].setText("");
	}
	
	public int CheckStatus()
	{
		return status;
	}

	public void ShowText(String string)
	{
		textField.setText(string);
	}
	
	public void StartPlaying()
	{
		if(status == STATUS_NEW_GAME)
			status = STATUS_PLAYING;
		else
			throw new IllegalArgumentException("YOU CANT CALL IT NOW");
	}
	
	public void ComputerMove()
	{
		theBoard.Lock();
		theBoard.ComputerMove();
		buttons[theBoard.LastMove_x()][theBoard.LastMove_y()].setText("O");
		theBoard.Unlock();
	}
	
	public void CheckWinStatus()
	{
		switch(theBoard.CheckWinStatus())
		{
		case Board.STATUS_COMPU_WIN:
			status=STATUS_RESULT_DETERMINED;
			textField.setText("You Lose.. Do you want to try again?");
			break;
		case Board.STATUS_HUMAN_WIN:
			status=STATUS_RESULT_DETERMINED;
			textField.setText("You Win! Do you want to play again?");
			break;
		case Board.STATUS_DRAW:
			status=STATUS_RESULT_DETERMINED;
			textField.setText("It's a draw game. Do you want to try again?");
			break;
		default:
			return;
		}
	}
	
}

