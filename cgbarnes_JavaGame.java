
 /* Game to check if there is 4 Xs in a row
 */
package tt;
import java.util.Scanner;
import java.util.Random;
public class cgbarnes_JavaGame {
	public static void printBoard(char board[][]) {//method to print out board
		for (int row = 0 ; row<board.length ; row++) {
			System.out.print("|");
			for (int col = 0 ; col< board[row].length; col++) {
				System.out.print(board[row][col]);
				System.out.print("|");
			}
			
			System.out.println();
		}
	}
	public static boolean checkBoard( char board[][]) {//method to check for 4 in a row
		for (int row = 0 ; row<board.length ; row++) {
			for (int col = 0 ; col< board[row].length -3; col++) {//horizontal
				if (board[row][col]=='x'
						&& board[row][col+1]=='x' 
						&& board[row][col+2]=='x' 
						&& board[row][col+3]=='x'){
					;
						return true;
						
				}
				
			}
		}
			
		for (int row = 0 ; row<board.length-3 ; row++) {
			for (int col = 0 ; col< board[row].length; col++) {//vertical
				if (board[row][col]=='x'
						&& board[row+1][col]=='x' 
						&& board[row+2][col]=='x' 
						&& board[row+3][col]=='x'){
					;
						return true;	
	
				}
			}
		}
		for (int row = 3; row<board.length ; row++) {
			for (int col = 0 ; col< board[row].length-3; col++) {//bottom right
				if (board[row][col]=='x'
						&& board[row-1][col+1]=='x' 
						&& board[row-2][col+2]=='x' 
						&& board[row-3][col+3]=='x'){
					;
						return true;	
	
				}
			}
		}
		for (int row = 0; row<board.length-3 ; row++) {
			for (int col = 0 ; col< board[row].length-3; col++) {//bottom left
				if (board[row][col]=='x'
						&& board[row+1][col+1]=='x' 
						&& board[row+2][col+2]=='x' 
						&& board[row+3][col+3]=='x'){
					;
						return true;	
	
				}
			}
		}
		
	return false;	
}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		

		char board[][] = new char[10][10]; //defines 2d array
		char x = 'x';
		char o = '.';
		
		boolean gameCont = true;
		
		for (int row = 0 ; row<board.length ; row++) {// populates 2d array
			for (int col = 0 ; col< board[row].length; col++) {
				board[row][col]= o;
			}
		}
		printBoard(board);
		
		System.out.println("(Enter either '1' or '2')"); //user Menu
		System.out.println("1: Singleplayer Mode ");
		System.out.println("2: Multiplayer Mode ");
		
		int mode = in.nextInt();
		if (mode==1) {//Singleplayer mode
			System.out.println("Selected Singleplayer Mode:\n");
			
			while (gameCont ==true){ 
	
				System.out.println("Enter row of X placement(1-10): ");
				int userRow = in.nextInt();
																			//reads user input
				System.out.println("Enter column of X placement(1-10): ");
				int userCol = in.nextInt();	
				
				board[userRow-1][userCol-1]= x; //puts user input in 2d array
				
				printBoard(board);
				if (checkBoard(board)==true) {//checks if user placed last X
					gameCont = false;
					System.out.println("Game over!, you placed last X");
					break;
				}
				else {
					
				}
				//puts cpu input in 2d array
				Random rand = new Random();
				int compRow = rand.nextInt(0,10);
				int compCol = rand.nextInt(0,10); 
				board[compRow][compCol]=x;
				
				System.out.println("Computer placed an X: ");
				printBoard(board);
				if (checkBoard(board)==true) {//checks if cpu placed last X
					gameCont = false;
					System.out.println("Game over!, CPU placed last X");
					break;
				}
				else {
					
				}
			}
		}
		if (mode == 2) {//Multiplayer mode
			System.out.println("Selected Multiplayer Mode:\n");
			while (gameCont ==true){ 
				
				System.out.println("Player1 Enter row of X placement(1-10): ");
				int userRow = in.nextInt();
																					//Reads in Player1 input and puts it in 2d Array
				System.out.println("Player1 Enter column of X placement(1-10): ");
				int userCol = in.nextInt();
				
				board[userRow-1][userCol-1]= x;
				
				printBoard(board);
				if (checkBoard(board)==true) {//Checks if Player1 wins
					gameCont = false;
					System.out.println("Game over!, Player1 placed last X");
					break;
				}
				else {
					
				}
				
				System.out.println("Player2 Enter row of X placement(1-10): ");
				userRow = in.nextInt();
																					//Reads in Player2 input and puts it in 2d array
				System.out.println("Player2 Enter column of X placement(1-10): ");
				userCol = in.nextInt();		
				
				board[userRow-1][userCol-1]= x;
				
				printBoard(board);
				if (checkBoard(board)==true) {// Checks if Player2 wins
					gameCont = false;
					System.out.println("Game over!, Player2 placed last X");
					break;
				}
				else {
					
				}
				
			} 
			
		}
	}		
}
	

