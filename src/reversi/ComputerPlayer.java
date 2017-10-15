package reversi;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
/** An class inherited from the abstract Player class that represents
 *  a computer player. 
 *  
 * @author Matt Baradine
 */
public class ComputerPlayer extends Player {
         
	/** Creates artificial input for row and col to progress 
	 * the game as a computer player. 
	 * 
	 * @param b	     An instance of the ReversiBoard class.
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
            Random r = new Random();
            System.out.println("");
            System.out.print("Player " + ourLetter + " is a computer.");
 
            while(true){
            int num1= r.nextInt(8) + 1;
            int num2= r.nextInt(8) + 1;
             
            if(b.gameBoard[num1][num2].equals("_"))
                {
                 	try {
                 			Thread.sleep(1000);
                 		} catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                b.updateBoard(num1, num2, turn);
 
                break;
                }
             
             
             
             
            }//loop
             
        } //playerMove
 
             
    } //ComputerPlayer