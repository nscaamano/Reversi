package reversi;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;

/** An class inherited from the ComputerPlayer class that represents
 *  a human player. 
 *  
 * @author Nicholas Caamano
 */
public class IntelligentComputerPlayer extends ComputerPlayer {
	
	/** Creates artificial input. Intelligent because 
	 * it determines which possibleMove will yield
	 * the most of its own piece in the following turn.
	 * 
	 * @param b	  An instance of the ReversiBoard class.
	 * @param turn   Boolean type to represent the turn of 
	 *               the move that will take place. Either X or O.
	 */
	@Override
    public void PlayerMove(ReversiBoard b, boolean turn){
        String ourLetter = "";
        String theirLetter = "";
        if(turn == false)
        {
        ourLetter = "X";
        theirLetter = "O";
        }
    else
        {
        ourLetter = "O";
        theirLetter = "X";
        }
        
        System.out.println("");
        System.out.print("Player " + ourLetter + " is an Intelligent computer.");
        
        
        
       
        int maxMove = 0;
        int rowToFind = 0; 
        int colToFind = 0;
        
        b.intelligentGameBoard = b.copyBoard(b.gameBoard);
        
       
        if(turn == false)
        {
        	outerloop:
        	for(int row = 1; row <= 8; row++)
        		for(int col = 1; col <= 8; col++)
        		{
        			if(b.gameBoard[row][col].equals("_"))
        			{
        				b.updateBoard(row, col, false);
        				maxMove = b.countX();
        				break outerloop;
        			}
        		}
        
      
         b.gameBoard = b.copyBoard(b.intelligentGameBoard);
        	for(int row = 1; row <= 8; row++)
        		for(int col = 1; col <= 8; col++)
        		{
        			b.gameBoard = b.copyBoard(b.intelligentGameBoard);
        			if(b.gameBoard[row][col].equals("_"))
        			{
        				b.updateBoard(row, col, false);
        				if(b.countX() > maxMove)
        					maxMove = b.countX();
        			}
        			
        		}
        	b.gameBoard = b.copyBoard(b.intelligentGameBoard);
        	outerloop:
        	for(int row = 1; row <= 8; row++)
        		for(int col = 1; col <= 8; col++)
        		{
        			b.gameBoard = b.copyBoard(b.intelligentGameBoard);
        			if(b.gameBoard[row][col].equals("_"))
        			{
        				b.updateBoard(row, col, false);
        				if(b.countX() == maxMove)
        				{
        					rowToFind = row;
        					colToFind = col;
        					break outerloop;
        				}
        					
        					
        			}
        		}
        	
        	b.gameBoard = b.copyBoard(b.intelligentGameBoard);
    
        	try {
     			Thread.sleep(1000);
     		} catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    b.updateBoard(rowToFind, colToFind, false);
        } // X turn
       
        else if(turn == true)
        {
        	outerloop:
        	for(int row = 1; row <= 8; row++)
        		for(int col = 1; col <= 8; col++)
        		{
        			if(b.gameBoard[row][col].equals("_"))
        			{
        				b.updateBoard(row, col, true);
        				maxMove = b.countO();
        				break outerloop;
        			}
        		}
        
      
         b.gameBoard = b.copyBoard(b.intelligentGameBoard);
        	for(int row = 1; row <= 8; row++)
        		for(int col = 1; col <= 8; col++)
        		{
        			b.gameBoard = b.copyBoard(b.intelligentGameBoard);
        			if(b.gameBoard[row][col].equals("_"))
        			{
        				b.updateBoard(row, col, true);
        				if(b.countO() > maxMove)
        					maxMove = b.countO();
        			}
        			
        		}
        	b.gameBoard = b.copyBoard(b.intelligentGameBoard);
        	outerloop:
        	for(int row = 1; row <= 8; row++)
        		for(int col = 1; col <= 8; col++)
        		{
        			b.gameBoard = b.copyBoard(b.intelligentGameBoard);
        			if(b.gameBoard[row][col].equals("_"))
        			{
        				b.updateBoard(row, col, true);
        				if(b.countO() == maxMove)
        				{
        					rowToFind = row;
        					colToFind = col;
        					break outerloop;
        				}
        					
        					
        			}
        		}
        	
        	b.gameBoard = b.copyBoard(b.intelligentGameBoard);
    
        	try {
     			Thread.sleep(1000);
     		} catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    b.updateBoard(rowToFind, colToFind, true);
        } // O turn
        
   
                

} //playerMove 

}//class body 