package reversi;
/** This class represents the actual board of Reversi that
 * the user sees and interacts with. Includes all methods
 * that use the board to function properly.
 *
 * @author Nicholas Caamano
 * @author Matt Baradine
 */
public class ReversiBoard implements Board {
  
	/** the string visual representation of the game board.*/
    public String[][] gameBoard;
    /** a copy of gameBoard used as a placeholder for intelligentComputer's purposes.*/
    public String[][] intelligentGameBoard;
    
    public final int ROWS = 8;
    
    public final int COLS = 8;
 
    /** Constructor for ReversiBoard. Simply calls generateBoard to get the game started.*/ 
    public ReversiBoard(){ 
        generateBoard();
     
    }
     
     
    /** Builds the contents of the gameBoard String array.*/
    public void generateBoard(){
           gameBoard  = new String[ROWS+1][COLS+1]; 
           
              for(int i = 0; i <= ROWS ; i++){  
                  if(i == 0) 
                  {
                      gameBoard[i][0] = " "; 
                      for(int i3 = 1; i3 <= COLS; i3++)
                          gameBoard[i][i3] =  (i3) + "";
                  }
                  else
                  {
                  gameBoard[i][0] =  "" + i; 
                    
                  for(int i2 = 1; i2 <= COLS; i2++) 
                     gameBoard[i][i2] = ".";
           
                    
                  }
              }
          
        gameBoard[4][4]="X";
        gameBoard[4][5]="O";
        gameBoard[5][4] ="O";
        gameBoard[5][5]="X";
     
       intelligentGameBoard = copyBoard(gameBoard);
    
                 
    }
 
    
    /** Searches the gameboard for a possible move
     *  to determine if any moves at all are available.
	 *
	 * @return   returns true if a possible move is present
	 * @return   returns false if a possible move is not present
	 */ 
    public boolean anyMoves(){
        boolean moves= false;
        for(int a=0; a< gameBoard.length; a++)
            for(int b=0; b<gameBoard.length; b++  )
            {
                if(gameBoard[a][b].equals("_"))
                    moves=true;
            }
         
        return moves;
         
    }
  
    
    /** Counts the amount of X pieces on the board.
	 * 
	 * @return	the number of X pieces as an integer type.
	 */  
    public int countX(){
        int xCount=0;
        for(int i = 0; i< 9; i++)
            for(int p = 0; p<9; p++)
                {
                        if (gameBoard[i][p].equals("X"))
                                xCount++;
                }
                  
            return xCount;
            }
 
    
    /** Counts the amount of O pieces on the board.
	 * 
	 * @return	 the number of O pieces as an integer type.
	 */ 
    public int countO()
    {
        int OCount=0;
            for(int i = 0; i< 9; i++)
                for(int p = 0; p<9; p++)
                  {
                    if(gameBoard[i][p].equals("O"))
                      OCount++;
                  }
            return OCount;  
    }
 
    /** Determines if the gameBoard has no empty spaces.
	 * 
	 * @return true if the gameBoard is full with no empty spaces.
	 * @return false if an empty space is present on the gameBoard.
	 */
    public boolean isFull()
    {
        boolean full = true;
          
        for(int i = 0; i< 9; i++)
           for(int p = 0; p<9; p++)
                {
                  if (gameBoard[i][p].equals(".") || gameBoard[i][p].equals("_"))
                    full= false;
                }
              
       return full;    
    }
        
    /** Clears the board of any possible moves ("_").
	 *  For the purpose of printing the next turn's possible moves. 
	 */
    public void refreshBoard(){
        for(int row = 1; row <= ROWS; row++)
            for(int col  =1; col <= COLS; col++)
            {
                if(gameBoard[row][col].equals("_"))
                    gameBoard[row][col] = ".";
            }
    }
     
     
    /** Prints a "_" at any location of a possibleMove for that turn.
     *  Determined by the rules of Reversi/Othello.
	 * 
	 * @param turn     a parameter of type boolean to determine which player's possible moves. Either X or O 
	 */
public void PossibleMoves(boolean turn)
    {
        if(turn == false)
        {
        for(int row = 1; row <= ROWS; row++)
            for(int col = 1; col <= COLS; col++)
            {
                if(gameBoard[row][col].equals("O"))
                    continue;
                else if(gameBoard[row][col].equals("."))
                    continue;
                else if(gameBoard[row][col].equals("X"))
                {// "X case begins
                      
                    if(col != 8 && gameBoard[row][col +1].equals("O")) // Checks East
                    {
                        for(int E = col + 2; E <= COLS; E++)
                        {
                            if(gameBoard[row][E].equals("O"))
                            {
//                              if(E == 8)
//                                  break;
                                continue;
                            }
                            else if(gameBoard[row][E].equals("_"))
                              break;
                            else if(gameBoard[row][E].equals("X"))
                                break;
                            else if(gameBoard[row][E].equals("."))
                            {
                                gameBoard[row][E] = "_";    
                                break;
                            }   
                        }
                              
                  
                    }//ends East check
                      
                    if(gameBoard[row][col -1].equals("O")) // checks West
                    {
                        for(int W = col - 2; W > 0; W--)
                        {
                            if(gameBoard[row][W].equals("O"))
                                continue;
                            else if(gameBoard[row][W].equals("_"))
                              break;
                            else if(gameBoard[row][W].equals("X"))
                                break;
                            else if(gameBoard[row][W].equals("."))
                            {
                                gameBoard[row][W] = "_";    
                                break;
                            }   
                        }   
                    } // ends west check
                      
                    if(gameBoard[row-1][col].equals("O")) // checks North
                    {
                        for(int N = row - 2; N > 0; N--)
                        {
                            if(gameBoard[N][col].equals("O"))
                                continue;
                            else if(gameBoard[N][col].equals("_"))
                                  break;
                            else if(gameBoard[N][col].equals("X"))
                                break;
                            else if(gameBoard[N][col].equals("."))
                            {
                                gameBoard[N][col] = "_";    
                                break;
                            }   
                        }   
                    }// ends North check
                      
                    if(row != 8 && gameBoard[row + 1][col].equals("O")) // Checks South
                    {
                        for(int S = row + 2; S <= ROWS; S++) // changed col to row
                        {
                            if(gameBoard[S][col].equals("O"))
                                continue;
                             
                            else if(gameBoard[S][col].equals("_"))
                              break;
                            else if(gameBoard[S][col].equals("X"))
                                break;
                            else if(gameBoard[S][col].equals("."))
                            {
                                gameBoard[S][col] = "_";    
                                break;
                            }   
                        } 
                          
                      
                    }//ends south check
                     
                     
                    if(gameBoard[row-1][col-1].equals("O"))//Northwest check
                    {
                         
                         
                        outerloop:
                        for(int rowNW = row -2; rowNW > 0; rowNW--)
                            for(int colNW = col - 2; colNW > 0; colNW--)
                            {
                                if(gameBoard[rowNW][colNW].equals("O"))
                                {
                                    rowNW--;
                                    continue;
                                }   
                                else if(gameBoard[rowNW][colNW].equals("_"))
                                {
                                    rowNW--;
                                    break outerloop;
                                }
                                     
                                else if(gameBoard[rowNW][colNW].equals("X"))
                                {
                                    rowNW--;
                                    break outerloop;
                                }
                                else if(gameBoard[rowNW][colNW].equals("."))
                                {
                                    gameBoard[rowNW][colNW] = "_";
                                    break outerloop;
                                }
                            }
                             
                     
                    } //NW check
                      
                    if(col != 8 && gameBoard[row-1][col+1].equals("O"))//NE check
                    {
                         
 
                        outerloop:
                        for(int rowNW = row -2; rowNW > 0; rowNW--)
                            for(int colNW = col + 2; colNW > 0; colNW++)
                            {
                                if(colNW>8)
                                    break outerloop;
                                 
                                if(gameBoard[rowNW][colNW].equals("O"))
                                {
                                    rowNW--;
                                    continue;
                                }   
                                else if(gameBoard[rowNW][colNW].equals("_"))
                                {
                                    rowNW--;
                                    break outerloop;
                                }
                                else if(gameBoard[rowNW][colNW].equals("X"))
                                {
                                    rowNW--;
                                    break outerloop;
                                }
                                else if(gameBoard[rowNW][colNW].equals("."))
                                {
                                    gameBoard[rowNW][colNW] = "_";
                                    break outerloop;
                                }
                            }
                    } //NE check ends
                     
                    if(row != 8 && gameBoard[row+1][col-1].equals("O"))//SW check
                    {
                         
                         
                        outerloop:
                        for(int rowSW = row +2; rowSW > 0; rowSW++)
                            for(int colNW = col - 2; colNW > 0; colNW--)
                            {
                                if(rowSW > 8)
                                    break outerloop;
                                if(gameBoard[rowSW][colNW].equals("O"))
                                {
                                     
                                    rowSW++;
                                    continue;
                                }   
                                else if(gameBoard[rowSW][colNW].equals("_"))
                                {
                                    rowSW++;
                                    break outerloop;
                                }
                                else if(gameBoard[rowSW][colNW].equals("X"))
                                {
                                    rowSW++;
                                    break outerloop;
                                }
                                else if(gameBoard[rowSW][colNW].equals("."))
                                {
                                    gameBoard[rowSW][colNW] = "_";
                                    break outerloop;
                                }
                            }
                             
                     
                    } //SW check ends
                     
                    if(row != 8 && col !=8 &&  gameBoard[row+1][col+1].equals("O"))//SE check
                    {
                         
                         
                        outerloop:
                        for(int rowNW = row +2; rowNW > 0 && rowNW <8 ; rowNW++)
                            for(int colNW = col + 2; colNW > 0; colNW++)
                            {
                                if(rowNW>8 || colNW>8)
                                    break outerloop;
                                 
                                if(gameBoard[rowNW][colNW].equals("O"))
                                {
                                    //if(rowNW==8 || colNW == 8)
                                        //break outerloop;
                                    rowNW++;
                                    continue;
                                }   
                                else if(gameBoard[rowNW][colNW].equals("_"))
                                {
                                    rowNW++;
                                    break outerloop;
                                }
                                else if(gameBoard[rowNW][colNW].equals("X"))
                                {
                                    rowNW++;
                                    break outerloop;
                                }
                                else if(gameBoard[rowNW][colNW].equals("."))
                                {
                                    gameBoard[rowNW][colNW] = "_";
                                    break outerloop;
                                }
                            }
                    } //SE check ends
                    
                      
                }// "X" case ends
                      
            }// second for loop col iteration ends
        }// X turn
         
         
         
         
        if(turn == true) // "O" turn case
        {
        for(int row = 1; row <= ROWS; row++)
            for(int col = 1; col <= COLS; col++)
            {
                if(gameBoard[row][col].equals("X"))
                    continue;
                else if(gameBoard[row][col].equals("."))
                    continue;
                else if(gameBoard[row][col].equals("O"))
                {// "O" space case begins
                      
                    if(col != 8 && gameBoard[row][col +1].equals("X")) // Checks East
                    {
                        for(int E = col + 2; E <= COLS; E++)
                        {
                            if(gameBoard[row][E].equals("X"))
                            {
                             
                                continue;
                            }
                            if(gameBoard[row][E].equals("_"))
                                break;
                            else if(gameBoard[row][E].equals("O"))
                                break;
                            else if(gameBoard[row][E].equals("."))
                            {
                                gameBoard[row][E] = "_";    
                                break;
                            }   
                        }
                              
                  
                    }//ends East check
                      
                    if(gameBoard[row][col -1].equals("X")) // checks West
                    {
                        for(int W = col - 2; W > 0; W--)
                        {
                            if(gameBoard[row][W].equals("X"))
                                continue;
                            if(gameBoard[row][W].equals("_"))
                                break;
                            else if(gameBoard[row][W].equals("O"))
                                break;
                            else if(gameBoard[row][W].equals("."))
                            {
                                gameBoard[row][W] = "_";    
                                break;
                            }   
                        }   
                    } // ends west check
                      
                    if(gameBoard[row-1][col].equals("X")) // checks North
                    {
                        for(int N = row - 2; N > 0; N--)
                        {
                            if(gameBoard[N][col].equals("X"))
                                continue;
                            if(gameBoard[N][col].equals("_"))
                                break;
                            else if(gameBoard[N][col].equals("O"))
                                break;
                            else if(gameBoard[N][col].equals("."))
                            {
                                gameBoard[N][col] = "_";    
                                break;
                            }   
                        }   
                    }// ends North check
                      
                    if(row != 8 && gameBoard[row + 1][col].equals("X") ) // Checks South
                    {
                        for(int S = row + 2; S <= ROWS; S++) // changed col to row
                        {
                            if(gameBoard[S][col].equals("X"))
                                continue;
                            if(gameBoard[S][col].equals("_"))
                                break;
                            else if(gameBoard[S][col].equals("O"))
                                break;
                            else if(gameBoard[S][col].equals("."))
                            {
                                gameBoard[S][col] = "_";    
                                break;
                            }   
                        } 
                          
                      
                    }//ends south check
                     
                     
                    if(gameBoard[row-1][col-1].equals("X"))//Northwest check
                    {
                         
                         
                        outerloop:
                        for(int rowNW = row -2; rowNW > 0; rowNW--)
                            for(int colNW = col - 2; colNW > 0; colNW--)
                            {
                                if(gameBoard[rowNW][colNW].equals("X"))
                                {
                                    rowNW--;
                                    continue;
                                }   
                                else if(gameBoard[rowNW][colNW].equals("_"))
                                {
                                    rowNW--;
                                    break outerloop;
                                }   
                                else if(gameBoard[rowNW][colNW].equals("O"))
                                {
                                    rowNW--;
                                    break outerloop;
                                }
                                else if(gameBoard[rowNW][colNW].equals("."))
                                {
                                    gameBoard[rowNW][colNW] = "_";
                                    break outerloop;
                                }
                            }
                             
                     
                    } //NW check
                      
                    if(col != 8 && gameBoard[row-1][col+1].equals("X"))//NE check
                    {
                         
                         
                        outerloop:
                        for(int rowNW = row -2; rowNW > 0; rowNW--)
                            for(int colNW = col + 2; colNW > 0; colNW++)
                            {
                                if(colNW> 8)
                                    break outerloop;
                                 
                                if(gameBoard[rowNW][colNW].equals("X"))
                                {
                                    rowNW--;
                                    continue;
                                }   
                                else if(gameBoard[rowNW][colNW].equals("_"))
                                {
                                    rowNW--;
                                    break outerloop;
                                }   
                                else if(gameBoard[rowNW][colNW].equals("O"))
                                {
                                    rowNW--;
                                    break outerloop;
                                }
                                else if(gameBoard[rowNW][colNW].equals("."))
                                {
                                    gameBoard[rowNW][colNW] = "_";
                                    break outerloop;
                                }
                            }
                    } //NE check ends
                     
                    if(row != 8 && gameBoard[row+1][col-1].equals("X"))//SW check
                    {
                         
                         
                        outerloop:
                        for(int rowSW = row +2; rowSW > 0; rowSW++)
                            for(int colNW = col - 2; colNW > 0; colNW--)
                            {
                                if(rowSW> 8)
                                    break outerloop;
                                if(gameBoard[rowSW][colNW].equals("X"))
                                {
                                    if(rowSW==8 || colNW == 8)
                                        break outerloop;
                                    rowSW++;
                                    continue;
                                }   
                                else if(gameBoard[rowSW][colNW].equals("_"))
                                {
                                     rowSW--;
                                    break outerloop;
                                }   
                                else if(gameBoard[rowSW][colNW].equals("O"))
                                {
                                    rowSW++;
                                    break outerloop;
                                }
                                else if(gameBoard[rowSW][colNW].equals("."))
                                {
                                    gameBoard[rowSW][colNW] = "_";
                                    break outerloop;
                                }
                            }
                             
                     
                    } //SW check ends
                     
                    if(row !=8 && col != 8 && gameBoard[row+1][col+1].equals("X"))//SE check
                    {
                         
                         
                        outerloop:
                        for(int rowNW = row +2; rowNW > 0; rowNW++)
                            for(int colNW = col + 2; colNW > 0; colNW++)
                            {
                                if(rowNW>8 || colNW>8)
                                    break outerloop;
                                 
                                if(gameBoard[rowNW][colNW].equals("X"))
                                {
                                    if(rowNW==8 || colNW == 8)
                                        break outerloop;
                                    rowNW++;
                                    continue;
                                }   
                                else if(gameBoard[rowNW][colNW].equals("_"))
                                {
                                    rowNW--;
                                    break outerloop;
                                }   
                                else if(gameBoard[rowNW][colNW].equals("O"))
                                {
                                    rowNW++;
                                    break outerloop;
                                }
                                else if(gameBoard[rowNW][colNW].equals("."))
                                {
                                    gameBoard[rowNW][colNW] = "_";
                                    break outerloop;
                                }
                            }
                    } //SE check ends
                    
                    
                     
                }// "Y" case ends
                      
            }// second for loop col iteration ends
        }// Y turn ends
          
    }//end PossibleMoves Method
 
     
/** Prints where the user wants to place a move.
 *  As a result other pieces flip according to
 *  the rules of Reversi/Othello.
 * 
 * @param rows		The row integer value for the move of the corresponding position on the gameBoard
 * @param cols	    The column integer value for the move of the corresponding position on the gameBoard
 * @param turn      The boolean value of which turn the move will be made for. True for O, false for X. 
 *
 */
    public void updateBoard(int rows, int cols, boolean turn){
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
             
        //checking east
        if(cols<8 && gameBoard[rows][cols+1].equals(theirLetter))
        {
            for(int E = cols+1; E<= COLS; E++)
            {
                if(gameBoard[rows][E].equals(ourLetter))
                {
                    int reverse = E;
                    for(; reverse >=cols;reverse--)
                        {
                        gameBoard[rows][reverse]= ourLetter;
                         
                        }
                }
                 
                 
            }
             
        }// end east
         
         
        //checking west
        if(cols>0 && gameBoard[rows][cols-1].equals(theirLetter))
        {
            for(int W = cols-1; W>=0; W-- )
            {
                if(gameBoard[rows][W].equals(ourLetter))
                {
                    int reverse = W;
                    for(; reverse<= cols;reverse++)
                        {
                        gameBoard[rows][reverse]= ourLetter;
                         
                        }
                }
                 
            }
             
        }// ending west
         
         
        //checking north
        if(rows> 0 &&gameBoard[rows-1][cols].equals(theirLetter))
        {
            for(int N = rows-1; N >=0; N--)
            {
                if(gameBoard[N][cols].equals(ourLetter))
                {
                    int reverse = N;
                    for(; reverse <= rows; reverse++)
                        {
                        gameBoard[reverse][cols]= ourLetter;
                         
                        }
                }
                 
            }
             
        }// ending north
         
         
         
        //checking south
        if(rows < 8 && gameBoard[rows+1][cols].equals(theirLetter)) // checks to see if the one below is their letter
        {
            for(int S = rows+1; S<=ROWS; S++ ) // starts loop going down
            {
                if(gameBoard[S][cols].equals(ourLetter)) // checks each spot to see if it is still their letter 
                {                                       // if it hits ourLetter then it reverses and prints over theirs with our letter
                    int reverse = S;
                    for(; reverse>=rows; reverse--) 
                        {
                            gameBoard[reverse][cols] = ourLetter; 
                             
                        }
                     
                }
                 
            }
                 
        }// ending south
         
         
         
        // checking north east
    if(rows > 0 && cols < 8 && gameBoard[rows-1][cols+1].equals(theirLetter))
    {
        for(int N = rows-1, E = cols +1; N>= 0 && E<= COLS; N--, E++)
            {
                if(gameBoard[N][E].equals(ourLetter))
                {
                    int reverseN= N;
                    int reverseE= E;
                     
                    for(; reverseN<= rows && reverseE>= cols; reverseN++, reverseE--)
                            {
                            gameBoard[reverseN][reverseE]= ourLetter;
                             
                            }
                }
                 
            }
         
    } //ending north east
         
     
     
    //checking north west
    if(rows > 0 && cols >0 && gameBoard[rows-1][cols-1].equals(theirLetter))
    {
        for(int N = rows-1, W = cols-1; N>= 0 && W>= 0; N--, W--)
            {
                if(gameBoard[N][W].equals(ourLetter))
                {
                    int reverseN= N;
                    int reverseW= W;
                     
                    for(; reverseN <= rows && reverseW <= cols; reverseN++, reverseW++)
                            {
                            gameBoard[reverseN][reverseW]= ourLetter;
                            updateBoard(reverseN, reverseW, turn);
                            }
                }
                 
            }
         
    } //ending north west
         
    
     
     
    // checking south east
    if(rows < 8 && cols < 8 && gameBoard[rows+1][cols+1].equals(theirLetter))
    {
        for(int S = rows+1, E = cols +1; S<= ROWS && E<= COLS; S++, E++)
            {
                if(gameBoard[S][E].equals(ourLetter))
                {
                    int reverseS= S;
                    int reverseE= E;
                     
                    for(; reverseS >= rows && reverseE >= cols; reverseS--, reverseE--)
                            {
                            gameBoard[reverseS][reverseE]= ourLetter;
                             
                            }
                }
                 
            }
         
    } //ending south east
         
    
     
    // checking south west
    if(rows < 8 && cols > 0 && gameBoard[rows+1][cols-1].equals(theirLetter))
    {
        for(int S = rows+1,W = cols -1 ; S<= ROWS && W >= 0 ; S++, W--)
            {
                 
                if(gameBoard[S][W].equals(ourLetter))
                {
                    int reverseS= S;
                    int reverseW= W;
                    for(; reverseS >= rows && reverseW <= cols; reverseS-- , reverseW++)
                            {
                            gameBoard[reverseS][reverseW]= ourLetter;
                             
                            }
                 
                }
                 
            }
         
    } //ending south west
         
 
         
    } //UpdateBoard
     
     
         
            
    /** Used to convert a 2D String array to a String for the purpose
     *  of printing to the console.
	 * 
	 * @param a	     The 2D String array that will be converted.
	 * @return		 The String representation of the array. 
	 */
    public static String stringArrayToString(String[][] a){
        String str = "";
        int r;
        int c;
        for(r= 0; r < a.length; r++)
        {
            for(c=0; c<a[r].length; c++)
            {
                 str+= ""+ a[r][c];
              
                 if(c!=a[r].length-1)
                     str += " ";
            }
            if(r==a.length-1) 
                return str;
              
            str += "\n";
        }
        return str; 
    }
      
    
    
    
    /** Used to copy the contents of one 2D String array into another.
	 * 
	 * @param a	     The 2D String array original
	 * @return		 The 2D String array copy.  
	 */
    public String[][] copyBoard (String[][] board)
    {
    	String[][] returnArray = new String[board.length][board[0].length];
    	for(int row = 0; row < board.length; row++)
    		for(int col = 0; col < board[0].length; col++)
    		{
    			returnArray[row][col] = board[row][col];
    		}
    	
    	return returnArray;
    }
      
      
} //Class reversiBoard