package ticTacToe;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GameFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int FRAME_HEIGHT = 400;
	public static final int FRAME_WIDTH  = 400;

	private JButton yesButton;
	private JButton noButton;
	private JButton resetButton;
	private BoardPanel boardPanel;
	private JPanel buttonPanel;
	
	public GameFrame() 
	{
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		class YesButtonListener implements ActionListener
		  { 
			  public void actionPerformed(ActionEvent event)
			  { 
				  if(boardPanel.CheckStatus()==BoardPanel.STATUS_NEW_GAME) 
				  {
					  boardPanel.StartPlaying();
					  boardPanel.ShowText("It's your turn now.");
				  }
				  if(boardPanel.CheckStatus()==BoardPanel.STATUS_RESULT_DETERMINED)
				  {
					  boardPanel.Reset();
				  }
					  
			  }
		  }
		class NoButtonListener implements ActionListener
		  { 
			  public void actionPerformed(ActionEvent event)
			  { 
				  if(boardPanel.CheckStatus()==BoardPanel.STATUS_NEW_GAME) 
				  {
					  boardPanel.StartPlaying();
					  boardPanel.ComputerMove();
					  boardPanel.ShowText("It's your turn now.");
				  }
				  if(boardPanel.CheckStatus()==BoardPanel.STATUS_RESULT_DETERMINED)
				  {
					  boardPanel.ShowText("Good Bye!");
					  System.exit(DO_NOTHING_ON_CLOSE);
				  }
			  }
		  }
		class ResetButtonListener implements ActionListener
		  { 
			  public void actionPerformed(ActionEvent event)
			  { 
				  	 boardPanel.Reset();
			  }
		  }
		
		boardPanel  = new BoardPanel();
		buttonPanel = new JPanel();
		
		yesButton = new JButton("YES");
		yesButton.addActionListener(new YesButtonListener());
		
		noButton  = new JButton("NO");
		noButton.addActionListener(new NoButtonListener());
		
		resetButton = new JButton("RESET");
		resetButton.addActionListener(new ResetButtonListener());

		buttonPanel.add(yesButton);
		buttonPanel.add(noButton);
		buttonPanel.add(resetButton);
		setLayout(new BorderLayout());
		add(boardPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.PAGE_END);	
	}

}
