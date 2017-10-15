package reversi;
import java.util.Scanner;

/** This abstract class represents the most general form of
 * a player containing the method that will utilize the player's
 * input to run the game. Will parent ComputerPlayer, HumanPlayer,
 * and IntelligentComputerPlayer.
 *
 * @author Nicholas Caamano
 * @author Matt Baradine
 */
public abstract class Player {
 
	/** Abstract method that will be inherited by other 
	 * child Player classes. Will provide input of row and col
	 * to progress the game. 
	 * 
	 * @param b	    An instance of ReversiBoard to utilize.
	 * @param b		A boolean type to represent which turn that will be used.
	 *              false for X, true for O
	 * @return			Description of c
	 */
    public abstract void PlayerMove(ReversiBoard b, boolean turn);
     
 
 
}
 