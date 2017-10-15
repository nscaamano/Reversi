INSTRUCTIONS
Reversi Alpha 
Nick Caamano
Matt Baradine

## Description
		This program represents a game called Reversi or Othello. The game prints a String that 
		represents the game board. This string is generated from a 2D string array that we 
		manipulate and updtate throughout the game in accordance with the rules. We do so through
		several methods in the ReversiBoard class. We have a method to determine possible
		moves, a method to update the board depending on the turn and move, a method to count X and O
		pieces, a method to refresh the board of lingering "_" for possible moves, and several other
		small methods that have clear functionality in the javadocs. We have classes to represent the 
		several different types of players all inherited from a parent Player class(Human, Computer, Intelligent Computer). 
		These classes take input and enter the moves for each turn and updates the board. The intelligent Computer
		works by predicting the amount of resulting pieces it would have for each possible move and picks
		the move that would yield the highest score. 

## Instructions
	
	In Bash:

	With a simple build tool compile the directory containing our files using javac *.java command in the bash line.
	Then run by entering the following command in this format:
	$ java Reversi [player] [player] 

	Types of players : Human, RandomComputerPlayer, IntelligentComputerPlayer
	ex: $ java Reversi Human RandomComputerPlayer
	 or $ java Reversi Human Human
	 or $ java Reversi RandomComputerPlayer IntelligentComputerPlayer


	 In IDE:

	 Find your IDE's configuration for arguments and type in the [player] [player] format. 

	 ex: Human Human
	 	 Human IntelligentComputerPlayer
