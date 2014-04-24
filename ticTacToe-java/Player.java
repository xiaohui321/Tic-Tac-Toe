package ticTacToe;

public class Player 
{
	public void Move(Board theBoard)
	{		
		int a = theBoard.CheckDotStatus(0,0)+ theBoard.CheckDotStatus(1,0) + theBoard.CheckDotStatus(2,0);
		int b = theBoard.CheckDotStatus(0,2)+ theBoard.CheckDotStatus(1,2) + theBoard.CheckDotStatus(2,2);
		int c = theBoard.CheckDotStatus(0,0)+ theBoard.CheckDotStatus(0,1) + theBoard.CheckDotStatus(0,2);
		int d = theBoard.CheckDotStatus(2,0)+ theBoard.CheckDotStatus(2,1) + theBoard.CheckDotStatus(2,2);
		//////////////////////////////////////////////////////////////
		//check if any dot that can win immediately // must do or lose
		//////////////////////////////////////////////////////////////
		
		//middle lines
		////if middle is computer's dot
		if (theBoard.CheckDotStatus(1,1)==Board.COMPU_DOT)
		{
			for (int i = 0; i<3; i++)
				for (int j = 0; j<3; j++)
					if(theBoard.CheckDotStatus(2-i,2-j)==Board.COMPU_DOT && theBoard.CheckDotEmpty(i,j))
					{
						theBoard.DotMove(Board.CHAR_COMPU,i,j);
						return;
					}
					
		}

		if(	a == 2 )
		{
			if(theBoard.CheckDotEmpty(0,0))
			{
				theBoard.DotMove(Board.CHAR_COMPU,0,0);
				return;
			}
			else if(theBoard.CheckDotEmpty(1,0))
			{
				theBoard.DotMove(Board.CHAR_COMPU,1,0);
				return;
			}
			else
			{
				theBoard.DotMove(Board.CHAR_COMPU,2,0);
				return;
			}
		}
		else if( b == 2 )
		{
			if(theBoard.CheckDotEmpty(0,2))
			{
				theBoard.DotMove(Board.CHAR_COMPU,0,2);
				return;
			}
			else if(theBoard.CheckDotEmpty(1,2))
			{
				theBoard.DotMove(Board.CHAR_COMPU,1,2);
				return;
			}
			else
			{
				theBoard.DotMove(Board.CHAR_COMPU,2,2);
				return;
			}
		}
		else if( c == 2 )
		{
			if(theBoard.CheckDotEmpty(0,0))
			{
				theBoard.DotMove(Board.CHAR_COMPU,0,0);
				return;
			}
			else if(theBoard.CheckDotEmpty(0,1))
			{
				theBoard.DotMove(Board.CHAR_COMPU,0,1);
				return;
			}
			else
			{
				theBoard.DotMove(Board.CHAR_COMPU,0,2);
				return;
			}
		}
		else if( d == 2 )
		{
			if(theBoard.CheckDotEmpty(2,0))
			{
				theBoard.DotMove(Board.CHAR_COMPU,2,0);
				return;
			}
			else if(theBoard.CheckDotEmpty(2,1))
			{
				theBoard.DotMove(Board.CHAR_COMPU,2,1);
				return;
			}
			else
			{
				theBoard.DotMove(Board.CHAR_COMPU,2,2);
				return;
			}
		}
		
		////else if middle is human's dot
		if (theBoard.CheckDotStatus(1,1)==Board.HUMAN_DOT)
		{
			for (int i = 0; i<3; i++)
				for (int j = 0; j<3; j++)
					if(theBoard.CheckDotStatus(2-i,2-j)==Board.HUMAN_DOT && theBoard.CheckDotEmpty(i,j))
					{
						theBoard.DotMove(Board.CHAR_COMPU,i,j);
						return;
					}
		}
		
		
		else if( a == 8 )
		{
			if(theBoard.CheckDotEmpty(0,0))
			{
				theBoard.DotMove(Board.CHAR_COMPU,0,0);
				return;
			}
			else if(theBoard.CheckDotEmpty(1,0))
			{
				theBoard.DotMove(Board.CHAR_COMPU,1,0);
				return;
			}
			else
			{
				theBoard.DotMove(Board.CHAR_COMPU,2,0);
				return;
			}
		}
		else if( b == 8 )
		{
			if(theBoard.CheckDotEmpty(0,2))
			{
				theBoard.DotMove(Board.CHAR_COMPU,0,2);
				return;
			}
			else if(theBoard.CheckDotEmpty(1,2))
			{
				theBoard.DotMove(Board.CHAR_COMPU,1,2);
				return;
			}
			else
			{
				theBoard.DotMove(Board.CHAR_COMPU,2,2);
				return;
			}
		}
		else if( c == 8 )
		{
			if(theBoard.CheckDotEmpty(0,0))
			{
				theBoard.DotMove(Board.CHAR_COMPU,0,0);
				return;
			}
			else if(theBoard.CheckDotEmpty(0,1))
			{
				theBoard.DotMove(Board.CHAR_COMPU,0,1);
				return;
			}
			else
			{
				theBoard.DotMove(Board.CHAR_COMPU,0,2);
				return;
			}
		}
		else if( d == 8 )
		{
			if(theBoard.CheckDotEmpty(2,0))
			{
				theBoard.DotMove(Board.CHAR_COMPU,2,0);
				return;
			}
			else if(theBoard.CheckDotEmpty(2,1))
			{
				theBoard.DotMove(Board.CHAR_COMPU,2,1);
				return;
			}
			else
			{
				theBoard.DotMove(Board.CHAR_COMPU,2,2);
				return;
			}
		}
		
		//////////////////////////////////////////////////////////////
		//check empty dot in the middle or corner
		//////////////////////////////////////////////////////////////
		
		//check if the middle dot empty
		if (theBoard.CheckDotEmpty(1,1))
		{
			theBoard.DotMove(Board.CHAR_COMPU,1,1);	
			return;
		}
		else if (theBoard.CheckDotEmpty(0,0))
		{
			theBoard.DotMove(Board.CHAR_COMPU,0,0);	
			return;
		}
		else if (theBoard.CheckDotEmpty(2,0))
		{
			theBoard.DotMove(Board.CHAR_COMPU,2,0);	
			return;
		}
		else if (theBoard.CheckDotEmpty(0,2))
		{
			theBoard.DotMove(Board.CHAR_COMPU,0,2);	
			return;
		}
		else if (theBoard.CheckDotEmpty(2,2))
		{
			theBoard.DotMove(Board.CHAR_COMPU,2,2);	
			return;
		}
		
		//////////////////////////////////////////////////////////////
		//Choose any empty dot
		//////////////////////////////////////////////////////////////
		for (int i = 0; i<3; i++)
			for (int j = 0; j<3; j++)
				if (theBoard.CheckDotEmpty(i,j))
					theBoard.DotMove(Board.CHAR_COMPU,i,j);
	}
	
	
}
