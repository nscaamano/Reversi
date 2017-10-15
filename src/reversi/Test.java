package reversi;
public class Test {
 
    public static void main(String[] args) {
         
         
        ReversiBoard  r = new ReversiBoard();
        Player p = new HumanPlayer();
        r.generateBoard();
        r.PossibleMoves(false);
        r.intelligentGameBoard = r.copyBoard(r.gameBoard);
        System.out.println(ReversiBoard.stringArrayToString(r.gameBoard));
       System.out.println(ReversiBoard.stringArrayToString(r.intelligentGameBoard));
       
       
        
        
       
 
    }
 
}