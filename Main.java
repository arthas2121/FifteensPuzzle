package FifteensPuzzle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
	public static Board initial_board = new Board(Board.initial_board);
	public static Board end_board = new Board(Board.end_board);
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(new File("src/FifteensPuzzle/inputfile.txt"));
		String[] text = new String[4];
		StringBuilder sb = new StringBuilder();
		int index = 0;
		while(scanner.hasNextLine()) {
			text[index] = scanner.nextLine();
			index++;
		}
		
		String[][] array = new String[4][4];
		
		for(int i = 0; i < text.length; i++) {
			array[i] = text[i].split(", ");
		}
		
		int[][] start_board = new int[4][4];
		
		for(int i = 0; i < 16; i++) {
			start_board[i/4][i%4] = Integer.parseInt(array[i/4][i%4]);
		}
		
		Board init_board = new Board(start_board);

		//Create a fringe to contain the unvisited child node, and a visited to contain the visited parent node
		Fringe fringe = new Fringe();
		fringe.board_arraylist.add(init_board);
		
		System.out.println(fringe);
		Board current_board = null;
		
		int count = 0;
		
		//Get one state from the fringe every time while the fringe is not empty
		while(fringe.board_arraylist.size() != 0) {
			
			//sort the fringe and get the first state with minimum fn
			System.out.println("The " + ++count + " steps: ");
			fringe.SortFringeByFn();
			current_board = fringe.board_arraylist.get(0);
			current_board.printBoard();
			
			//Check if the state is equal to the end state, if it is, end the while loop and print the process.
			if(current_board.isEqual(end_board)) {
				System.out.println("\n\n\n\n\n\n");
				System.out.println("End_board is reached!");
				current_board.printBoard();
				int stepnum = 0;
				while(current_board.parent_board != null) {
					System.out.println("The former board state:");
					current_board.parent_board.printBoard();
					current_board = current_board.parent_board;
					stepnum++;
				}
				System.out.println("The total number of steps to reach the end board state is " + stepnum);
				break;
			}
			
			
			// Check if it is ok for 0 to move in eight directions
			for(int possibleStep = 1; possibleStep <= 8; possibleStep++) {
				
				Board next_board = null;
				if(possibleStep == 1) {
					if(current_board.Down1Left2()) {
						next_board = current_board.goDown1Left2();
					}else {
						continue;
					}
				}else if(possibleStep == 2) {
					if(current_board.Down1Right2()) {
						next_board = current_board.goDown1Right2();
					}else {
						continue;
					}
				}else if(possibleStep == 3) {
					if(current_board.Down2Left1()) {
						next_board = current_board.goDown2Left1();
					}else {
						continue;
					}
				}else if(possibleStep == 4) {
					if(current_board.Down2Right1()) {
						next_board = current_board.goDown2Right1();
					}else {
						continue;
					}
				}else if(possibleStep == 5) {
					if(current_board.Up1Left2()) {
						next_board = current_board.goUp1Left2();
					}else {
						continue;
					}
				}else if(possibleStep == 6) {
					if(current_board.Up1Right2()) {
						next_board = current_board.goUp1Right2();
					}else {
						continue;
					}
				}else if(possibleStep == 7) {
					if(current_board.Up2Left1()) {
						next_board = current_board.goUp2Left1();
					}else {
						continue;
					}
				}else if(possibleStep == 8) {
					if(current_board.Up2Right1()) {
						next_board = current_board.goUp2Right1();
					}else {
						continue;
					}
				}

				fringe.board_arraylist.add(next_board);
			}
				fringe.board_arraylist.remove(current_board);
			}
		
		}
		
	}

