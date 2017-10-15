package reversi;
/** The class containing the main method of the program 
 * that utilizes all of the classes to control the flow and functionality
 *  of the game 
 * 
 * @author Matt Baradine
 */
	public class Reversi {
       
     
     
    public static void main(String[] args) {
        Player p1 = null;
        Player p2 = null;
         
        if(args[0].equals("Human"))
            {
                p1 = new HumanPlayer();
            }
         
        if(args[0].equals("RandomComputerPlayer"))
            {
             p1 = new ComputerPlayer();
            }
        if(args[0].equals("IntelligentComputerPlayer"))
        {
        	p1 = new IntelligentComputerPlayer();
        }
 
        if(args[1].equals("Human"))
            {
             p2 = new HumanPlayer();
            }
         
        if(args[1].equals("RandomComputerPlayer"))
            {
            p2 = new ComputerPlayer();
            }
        if(args[1].equals("IntelligentComputerPlayer"))
        {
        	p2 = new IntelligentComputerPlayer();
        }
         
         
        int rounds = 0;
        ReversiBoard  r = new ReversiBoard();
        r.generateBoard();
        boolean turn = false;
        boolean gameWin = false;
         
        while(gameWin == false)
        {
 
             
            if(rounds==0)
            {
                r.PossibleMoves(turn);
                System.out.println("");
                System.out.println("Welcome to Reversi!  Moves should be entered in \"[row] [column]\" format.");
                System.out.println("");
                System.out.println(ReversiBoard.stringArrayToString(r.gameBoard));
            }
             
           
             
            if(turn == false)
                {
                p1.PlayerMove(r, turn);
                r.refreshBoard();
                 
                turn = true;
                }
            else
                {
                 
                p2.PlayerMove(r, turn);
                r.refreshBoard();
                 
                turn = false;
                }
            System.out.println("");
        rounds++;
             
            r.PossibleMoves(turn);
            System.out.println("");
            System.out.println(ReversiBoard.stringArrayToString(r.gameBoard));
 
            if(r.isFull() || !r.anyMoves()|| r.countO()==0 || r.countX() == 0) // wind if statement
            {
                if(r.countX()>r.countO())
                {
                    System.out.println("");
                    System.out.println("Congratulations player X has won!");
                    System.out.println("Player X Score = " + r.countX() + ", Player O Score = " + r.countO());
                    break;
                }
                 
                if(r.countO()>r.countX())
                {
                    System.out.println("");
                    System.out.println("Congratulations player O has won!");
                    System.out.println("Player O Score = " + r.countO() + ", Player X Score = " + r.countX());
                    break;
                }
             
             
             
             
        }
 
    }
 
}
    
	}