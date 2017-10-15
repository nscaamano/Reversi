package reversi;
public interface Board {
     
	
    public void PossibleMoves(boolean turn);
    public void updateBoard(int rows, int cols, boolean turn);
    public void generateBoard();
    public boolean anyMoves();
    public int countX();
    public int countO();
    public boolean isFull();
    public void refreshBoard();
   
    
     
     
     
     
     
}