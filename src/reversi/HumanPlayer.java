package reversi;
import java.util.Scanner;
/** An class inherited from the abstract Player class that represents
 *  a human player. 
 *  
 * @author Matt Baradine
 */
public class HumanPlayer extends Player {
 
         
         
        @Override
        public void PlayerMove(ReversiBoard b, boolean turn) {
            String ourLetter = "";
            String theirLetter = "";
            int rows=0;
            int cols=0;
            boolean run = true;
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
            Scanner s  =new Scanner(System.in);
             
            System.out.println("");
            System.out.print("Enter your move, "+ ourLetter +" player: ");
             
            while(run)
            {
                     
                     
                 
            if(!s.hasNextInt())
                rows=Character.getNumericValue(s.next().charAt(0));
            else
                rows=s.nextInt();
             
            if(!s.hasNextInt())
                cols=Character.getNumericValue(s.next().charAt(0));
            else
                cols=s.nextInt();   
                 
                     
            if(rows>8 || rows< 1 || cols> 8 || cols<1 || !b.gameBoard[rows][cols].equals("_"))
                {
                 
                System.out.print("Invalid entry, retry and enter valid coordinates. ");
                }
            else
            {
                break;
            }
             
            }
                 
        
            b.updateBoard(rows, cols, turn);
             
         
        }
 
 
    }