package FifteensPuzzle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Fringe {
	
	ArrayList<Board> board_arraylist = new ArrayList<Board>();
	
	// Sort the fringe according to Fn value by overriding the compare method of the Comparator.
	public void SortFringeByFn() {
		Collections.sort(board_arraylist, new Comparator<Board>(){
			@Override
			//put the state with smaller fn in the front, and the state with larger fn to the end.
			public int compare(Board first_board, Board second_board) {
				// TODO Auto-generated method stub
				if(first_board.fn > second_board.fn) {
					return 1;
				}else if(first_board.fn < second_board.fn) {
					return -1;
				}else {
					return 0;
				}
			}
		});
		System.out.println("The size of the fringe is " + this.board_arraylist.size());

	}	
	
}

