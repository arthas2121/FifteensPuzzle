package FifteensPuzzle;

public class Heuristic {
	
	public static int heuristicFunction(Board current_board) {
		int heuristic_value = 0;
		
		// The knight_moves between two positions
		int[] hn_array = new int[] {0,  3,  2,  5,  3,  4,  1,  2,  2,  1,  4,  3,  5,  2,  3,  2,  3,  0,
		                       3,  2,  2,  3,  2,  1,  1,  2,  1,  4,  2,  3,  2,  3,  2,  3,  0,  3,
		                       1,  2,  3,  2,  4,  1,  2,  1,  3,  2,  3,  2,  5,  2,  3,  0,  2,  1,
		                       4,  3,  3,  4,  1,  2,  2,  3,  2,  5,  3,  2,  1,  2,  0,  3,  2,  3,
		                       3,  2,  1,  2,  2,  1,  4,  3,  4,  3,  2,  1,  3,  0,  3,  2,  2,  3,  2,  1,  1,  2,  1,  4,
		                       1,  2,  3,  4,  2,  3,  0,  3,  1,  2,  3,  2,  4,  1,  2,  1,  2,  1,  2,  3,  3,  2,  3,  0,
		                       2,  1,  2,  3,  3,  4,  1,  2,  2,  1,  4,  3,  3,  2,  1,  2,  0,  3,  2,  3,  3,  2,  1,  2,
		                       1,  2,  1,  4,  2,  3,  2,  1,  3,  0,  3,  2,  4,  3,  2,  1,  4,  1,  2,  1,  1,  2,  3,  2,
		                       2,  3,  0,  3,  1,  2,  3,  4,  3,  4,  1,  2,  2,  1,  2,  3,  3,  2,  3,  0,  2,  1,  2,  3,
		                       5,  2,  3,  2,  2,  1,  4,  3,  3,  4,  1,  2,  0,  3,  2,  5,  2,  3,  2,  3,  1,  2,  1,  4,
		                       2,  3,  2,  1,  3,  0,  3,  2,  3,  2,  3,  2,  4,  1,  2,  1,  1,  2,  3,  2,  2,  3,  0,  3,
		                       2,  3,  2,  5,  3,  4,  1,  2,  2,  1,  4,  3,  5,  2,  3,  0};
		  
		/*
		for(int i = 0; i < Board.length_board; i++) {
			for(int j = 0; j < Board.length_board; j++) {
				secondForLoop: for(int m = 0; m < Board.length_board; m++) {
					for(int n = 0; n < Board.length_board; n++) {
						if(current_board.array_board[i][j] == Board.end_board[m][n]) {
							if((Math.abs(m-i) + Math.abs(n-j)) % 3 == 0) {
							heuristic_value += ((Math.abs(m-i) + Math.abs(n-j)) / 3); 
							}else if((Math.abs(m-i) + Math.abs(n-j)) % 3 == 1) {
								heuristic_value += ((Math.abs(m-i) + Math.abs(n-j)) / 3 + 2); 
							}else if((Math.abs(m-i) + Math.abs(n-j)) % 3 == 2) {
								heuristic_value += ((Math.abs(m-i) + Math.abs(n-j)) / 3 + 1); 
							}
							break secondForLoop;
						}
					}
				}
			}
		}
		*/
		
		// two two-for loops in order to get the heuristic value by adding the knight_moves of all the numbers that are in the wrong place.
		for(int i = 0; i < Board.length_board; i++) {
			for(int j = 0; j < Board.length_board; j++) {
				secondForLoop: for(int m = 0; m < Board.length_board; m++) {
					for(int n = 0; n < Board.length_board; n++) {
						if(current_board.array_board[i][j] == Board.end_board[m][n]) {
							int firstPosition = 4*i+j;
							int secondPosition = 4*m+n;
							heuristic_value += hn_array[16*firstPosition+secondPosition];
							break secondForLoop;
						}
					}
				}
			}
		}
		
		
		return heuristic_value;		
	}
	
}
