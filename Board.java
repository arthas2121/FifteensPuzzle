package FifteensPuzzle;

import java.util.ArrayList;

public class Board {
	
	// Create board state
	public int[][] array_board;
	
	// Length or width of the board
	public static final int length_board = 4;
	
	//The input board state
	public static final int[][] initial_board = {{1,2,12,13},{5,6,7,8},{9,3,4,0},{11,14,15,10}};
	
	//The output board state
	public static final int[][] end_board = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
	
	//hn is the estimated cost, gn is the incurred cost, fn is the total cost (hn+gn)
	public int hn = 0, gn = 0, fn = 0;
	
	//Two constructors with or without parameter in case to use
	public Board() {
		super();
	}
	
	public Board(int[][] array_board) {
		super();
		this.array_board = array_board;
		this.gn = 0;
		this.hn = Heuristic.heuristicFunction(this);
		this.fn = this.gn + this.hn;
		//this.hn = heuristic function
	}
	
	//Parent board
	public Board parent_board;
	
	//Create an ArrayList to store all Child boards
	public ArrayList<Board> child_board = new ArrayList<Board>();
	
	
	// Check if the current state is equal to a state
	public boolean isEqual(Board board) {
		boolean isEqual = true;
		for(int i = 0; i < length_board && isEqual == true; i++) {
			for(int j = 0; j < length_board; j++) {
				if(array_board[i][j] != board.array_board[i][j]) {
					isEqual = false;
					break;
				}
			}
		}
		return isEqual;
		
	}
	
	// Function to get a copy of the array in order to use in the moving step.
	public int[][] copyArray(){
		int[][] copy_array = new int[4][4];
		for(int i = 0; i < length_board; i++) {
			for(int j = 0; j < length_board; j++) {
				copy_array[i][j] = array_board[i][j];
			}
		}
		return copy_array;
	}
	
	// print the current state
	public void printBoard() {
		
		System.out.println("The board state is like below:");
		
		for(int i = 0; i < length_board; i++) {
			for(int j = 0; j < length_board; j++) {
				System.out.print(this.array_board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	// Check if 0 can move Up2Left1
	public boolean Up2Left1() {
		
		//two for loops return false if there is no space for 0 to move Up2Left1.
		boolean canGo = true;
		label: for(int i = 0; i < length_board; i++) {
			for(int j = 0; j < length_board; j++) {
				if(array_board[i][j] == 0 && ((i - 2) < 0 || (j - 1) < 0)) {
					canGo = false;
					break label;
				}
			}
		}
		return canGo;
	}
	
	//Return a board after the 0 moves Up2Left1
	public Board goUp2Left1() {
		
		// Create a new board using copyArray function and then swap the value with 0;
		Board new_board = new Board(this.copyArray());
		 label: for(int i = 0; i < length_board; i++) {
			for(int j = 0; j < length_board; j++) {
				if(new_board.array_board[i][j] == 0) {
					new_board.array_board[i][j] = new_board.array_board[i-2][j-1];
					new_board.array_board[i-2][j-1] = 0;
					break label;
				}
			}
		}
		
		// Increment gn, re-calculate hn, and sum gn and hn to get fn. Set the parent_board of the new_board to current_board and child_board as the new_board.
		new_board.gn = this.gn + 1;
		new_board.hn = Heuristic.heuristicFunction(new_board);
		new_board.fn = new_board.gn + new_board.hn;
		new_board.parent_board = this;
		this.child_board.add(new_board);
		return new_board;
	}
	
	public boolean Up1Left2() {
		
		boolean canGo = true;
		label: for(int i = 0; i < length_board; i++) {
			for(int j = 0; j < length_board; j++) {
				if(array_board[i][j] == 0 && ((i - 1) < 0 || (j - 2) < 0)) {
					canGo = false;
					break label;
				}
			}
		}
		return canGo;
	}
	
	public Board goUp1Left2() {
		
		Board new_board = new Board(this.copyArray());
		label: for(int i = 0; i < length_board; i++) {
			for(int j = 0; j < length_board; j++) {
				if(new_board.array_board[i][j] == 0) {
					new_board.array_board[i][j] = new_board.array_board[i-1][j-2];
					new_board.array_board[i-1][j-2] = 0;
					break label;
				}
			}
		}
		
		new_board.gn = this.gn + 1;
		new_board.hn = Heuristic.heuristicFunction(new_board);
		new_board.fn = new_board.gn + new_board.hn;
		new_board.parent_board = this;
		this.child_board.add(new_board);
		return new_board;
	}
	
	public boolean Up2Right1() {
		boolean canGo = true;
		label: for(int i = 0; i < length_board; i++) {
			for(int j = 0; j < length_board; j++) {
				if(array_board[i][j] == 0 && ((i - 2) < 0 || (j + 1) >= length_board)) {
					canGo = false;
					break label;
				}
			}
		}
		return canGo;
	}
	
	public Board goUp2Right1() {
		
		Board new_board = new Board(this.copyArray());
		label: for(int i = 0; i < length_board; i++) {
			for(int j = 0; j < length_board; j++) {
				if(new_board.array_board[i][j] == 0) {
					new_board.array_board[i][j] = new_board.array_board[i-2][j+1];
					new_board.array_board[i-2][j+1] = 0;
					break label;
				}
			}
		}
		
		new_board.gn = this.gn + 1;
		new_board.hn = Heuristic.heuristicFunction(new_board);
		new_board.fn = new_board.gn + new_board.hn;
		new_board.parent_board = this;
		this.child_board.add(new_board);
		return new_board;
	}
	
	public boolean Up1Right2() {
		
		boolean canGo = true;
		label: for(int i = 0; i < length_board; i++) {
			for(int j = 0; j < length_board; j++) {
				if(array_board[i][j] == 0 && ((i - 1) < 0 || (j + 2) >= length_board)) {
					canGo = false;
					break label;
				}
			}
		}
		return canGo;
	}
	
	public Board goUp1Right2() {
		
		Board new_board = new Board(this.copyArray());
		label: for(int i = 0; i < length_board; i++) {
			for(int j = 0; j < length_board; j++) {
				if(new_board.array_board[i][j] == 0) {
					new_board.array_board[i][j] = new_board.array_board[i-1][j+2];
					new_board.array_board[i-1][j+2] = 0;
					break label;
				}
			}
		}
		
		new_board.gn = this.gn + 1;
		new_board.hn = Heuristic.heuristicFunction(new_board);
		new_board.fn = new_board.gn + new_board.hn;
		new_board.parent_board = this;
		this.child_board.add(new_board);
		return new_board;
	}
	
	public boolean Down1Right2() {
		
		boolean canGo = true;
		label: for(int i = 0; i < length_board; i++) {
			for(int j = 0; j < length_board; j++) {
				if(array_board[i][j] == 0 && ((i + 1) >= length_board || (j + 2) >= length_board)) {
					canGo = false;
					break label;
				}
			}
		}
		return canGo;
	}
	
	public Board goDown1Right2() {
		
		Board new_board = new Board(this.copyArray());
		label: for(int i = 0; i < length_board; i++) {
			for(int j = 0; j < length_board; j++) {
				if(new_board.array_board[i][j] == 0) {
					new_board.array_board[i][j] = new_board.array_board[i+1][j+2];
					new_board.array_board[i+1][j+2] = 0;
					break label;
				}
			}
		}
		
		new_board.gn = this.gn + 1;
		new_board.hn = Heuristic.heuristicFunction(new_board);
		new_board.fn = new_board.gn + new_board.hn;
		new_board.parent_board = this;
		this.child_board.add(new_board);
		return new_board;
	}
	
	public boolean Down2Right1() {
		
		boolean canGo = true;
		label: for(int i = 0; i < length_board; i++) {
			for(int j = 0; j < length_board; j++) {
				if(array_board[i][j] == 0 && ((i + 2) >= length_board || (j + 1) >= length_board)) {
					canGo = false;
					break label;
				}
			}
		}
		return canGo;
	}
	
	public Board goDown2Right1() {
		
		Board new_board = new Board(this.copyArray());
		label: for(int i = 0; i < length_board; i++) {
			for(int j = 0; j < length_board; j++) {
				if(new_board.array_board[i][j] == 0) {
					new_board.array_board[i][j] = new_board.array_board[i+2][j+1];
					new_board.array_board[i+2][j+1] = 0;
					break label;
				}
			}
		}
		
		new_board.gn = this.gn + 1;
		new_board.hn = Heuristic.heuristicFunction(new_board);
		new_board.fn = new_board.gn + new_board.hn;
		new_board.parent_board = this;
		this.child_board.add(new_board);
		return new_board;
	}
	
	public boolean Down2Left1() {
		
		boolean canGo = true;
		label: for(int i = 0; i < length_board; i++) {
			for(int j = 0; j < length_board; j++) {
				if(array_board[i][j] == 0 && ((i + 2) >= length_board || (j - 1) < 0)) {
					canGo = false;
					break label;
				}
			}
		}
		return canGo;
	}
	
	public Board goDown2Left1() {
		
		Board new_board = new Board(this.copyArray());
		label: for(int i = 0; i < length_board; i++) {
			for(int j = 0; j < length_board; j++) {
				if(new_board.array_board[i][j] == 0) {
					new_board.array_board[i][j] = new_board.array_board[i+2][j-1];
					new_board.array_board[i+2][j-1] = 0;
					break label;
				}
			}
		}
		
		new_board.gn = this.gn + 1;
		new_board.hn = Heuristic.heuristicFunction(new_board);
		new_board.fn = new_board.gn + new_board.hn;
		new_board.parent_board = this;
		this.child_board.add(new_board);
		return new_board;
	}
	
	public boolean Down1Left2() {
		
		boolean canGo = true;
		label: for(int i = 0; i < length_board; i++) {
			for(int j = 0; j < length_board; j++) {
				if(array_board[i][j] == 0 && ((i + 1) >= length_board || (j - 2) < 0)) {
					canGo = false;
					break label;
				}
			}
		}
		return canGo;
	}
	
	public Board goDown1Left2() {
		
		Board new_board = new Board(this.copyArray());
		label: for(int i = 0; i < length_board; i++) {
			for(int j = 0; j < length_board; j++) {
				if(new_board.array_board[i][j] == 0) {
					new_board.array_board[i][j] = new_board.array_board[i+1][j-2];
					new_board.array_board[i+1][j-2] = 0;
					break label;
				}
			}
		}
		
		new_board.gn = this.gn + 1;
		new_board.hn = Heuristic.heuristicFunction(new_board);
		new_board.fn = new_board.gn + new_board.hn;
		new_board.parent_board = this;
		this.child_board.add(new_board);
		return new_board;
	}
	
	
	
}
