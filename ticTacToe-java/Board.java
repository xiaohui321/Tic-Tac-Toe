package ticTacToe;



public class Board 
{
	public static final int EMPTY_DOT    		 = 0;
	public static final int HUMAN_DOT   		 = 4;
	public static final int COMPU_DOT   		 = 1;
	
	public static final int STATUS_UNDETERMINED  = 10;
	public static final int STATUS_DRAW          = 11;
	public static final int STATUS_HUMAN_WIN     = 12;
	public static final int STATUS_COMPU_WIN     = 13;
	
	public static final int CHAR_HUMAN  		 = 15;
	public static final int CHAR_COMPU  		 = 16;
	
	public static final int LOCK_LOCKED  		 = 17;
	public static final int LOCK_UNLOCKED 		 = 18;
	
	private int[][] board = new int [3][3];
	
	private int counter;
	private int status;
	private int lock;
	private Player computer;
	
	private int LastMove_x;
	private int LastMove_y;
	
	public Board() 	{
		computer = new Player();
		Reset();
	}
	
	public void Reset()	{
		counter = 0;
		status  = STATUS_UNDETERMINED;
		LastMove_x = -1;
		LastMove_y = -1;
		lock = LOCK_UNLOCKED;
		//let the board be empty
		for(int i = 0; i<3;i++)
			for(int j = 0; j<3;j++)
			{
				board[i][j] = EMPTY_DOT;
			}
	}
	
	public boolean CheckDotEmpty(int x, int y)	{
		if(board[x][y] ==EMPTY_DOT)
			return true;
		else
			return false;
	}
	
	public int CheckDotStatus(int x, int y)	{
		return board[x][y];
	}
	
	public boolean CheckDotNotBelongToHuman(int x, int y)	{
		if(board[x][y] != HUMAN_DOT )
			return true;
		else
			return false;
	}
	
	public void DotMove(int character,int x, int y) {
		if(character== CHAR_HUMAN && lock == LOCK_LOCKED)
			return;
		if (character!= CHAR_HUMAN && character!= CHAR_COMPU)
			throw new IllegalArgumentException("Wrong Character");
		
		if(board[x][y] != EMPTY_DOT)
			throw new IllegalArgumentException("Cant move there");
			
		counter++;
		if (character== CHAR_HUMAN)
			board[x][y] = HUMAN_DOT;
		else
			board[x][y] = COMPU_DOT;
		LastMove_x = x;
		LastMove_y = y;
		UpdateStatus();
	}
	
	public void UpdateStatus()	{
		if(board[1][1]!=EMPTY_DOT  &&  ((board[0][0] == board[1][1]  && board[1][1] == board[2][2])
								    || 	(board[0][1] == board[1][1]  && board[1][1] == board[2][1])
								    || 	(board[0][2] == board[1][1]  && board[1][1] == board[2][0])
								   	|| 	(board[1][0] == board[1][1]  && board[1][1] == board[1][2])))
		{
			if(board[1][1] == HUMAN_DOT)
				status=STATUS_HUMAN_WIN;
			else
				status=STATUS_COMPU_WIN;
		}
		else if (board[0][0]!=EMPTY_DOT && ((board[0][0] == board[0][1]  && board[0][1] == board[0][2])
							  			|| 	(board[0][0] == board[1][0]  && board[1][0] == board[2][0])))
		{
			if(board[0][0] == HUMAN_DOT)
				status=STATUS_HUMAN_WIN;
			else
				status=STATUS_COMPU_WIN;
		}
		else if (board[2][2]!=EMPTY_DOT && ((board[2][0] == board[2][1]  && board[2][1] == board[2][2])
										|| 	(board[0][2] == board[1][2]  && board[1][2] == board[2][2])))
		{
			if(board[2][2] == HUMAN_DOT)
				status=STATUS_HUMAN_WIN;
			else
				status=STATUS_COMPU_WIN;
		}
		else if (counter == 9)
		{
			status=STATUS_DRAW;
		}
	}
	
	public void ComputerMove()	{
		computer.Move(this);
	}
	
	public int LastMove_x()	{
		return LastMove_x;
	}
	
	public int LastMove_y()
	{
		return LastMove_y;
	}
	
	public int CheckWinStatus()
	{
		return status;			
	}

	public void Lock() {
		lock = LOCK_LOCKED;
	}
	
	public void Unlock(){
		lock = LOCK_UNLOCKED;
	}

	
	public boolean LockedStatus()
	{
		if (lock == LOCK_LOCKED)
			return true;
		else
			return false;
	}
}
