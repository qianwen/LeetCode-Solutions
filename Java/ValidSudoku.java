/* Valid Sudoku 
 * Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */
import java.util.*;

public class ValidSudoku {
	public static void main(String[] args) {
		// false
        char[][] board = new char[][]{
        	{'.', '.', '4', '.', '.', '.', '6', '3', '.'},
        	{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
        	{'5', '.', '.', '.', '.', '.', '.', '9', '.'},
        	{'.', '.', '.', '5', '6', '.', '.', '.', '.'},
        	{'4', '.', '3', '.', '.', '.', '.', '.', '1'},
        	{'.', '.', '.', '7', '.', '.', '.', '.', '.'},
        	{'.', '.', '.', '5', '.', '.', '.', '.', '.'},
        	{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
        	{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
        };
        System.out.println(isValidSudoku(board));

        // false
        char[][] board2 = new char[][]{
        	{'.', '.', '.', '.', '.', '.', '5', '.', '.'},
        	{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
        	{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
        	{'9', '3', '.', '.', '2', '.', '4', '.', '.'},
        	{'.', '.', '7', '.', '.', '.', '3', '.', '.'},
        	{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
        	{'.', '.', '.', '3', '4', '.', '.', '.', '.'},
        	{'.', '.', '.', '.', '.', '3', '.', '.', '.'},
        	{'.', '.', '.', '.', '.', '5', '2', '.', '.'},
        };

        System.out.println(isValidSudoku(board2));
        System.out.println(isValidSudoku2(board2));
    }
    
    // check separately wheather all three rules are met
	public static boolean isValidSudoku(char[][] board) {
		HashSet<Character> set = new HashSet<Character>();
		int length = board.length;

        // check the row 
		for (int i = 0; i < length; i++) {
			set.clear();

			for (int j = 0; j < length; j++) {
				if(!validation(set, board[i][j])) {
					return false;
				}
			}
		}

        // check the col 
		for (int i = 0; i < length; i++) {
			set.clear();

			for (int j = 0; j < length; j++) {
				if(!validation(set, board[j][i])) {
					return false;
				}
			}
		}

        // valid the block 
		for (int i = 0; i < length; i+=3) {
			for (int j = 0; j < length; j+=3) {
				set.clear();

				for (int k = 0; k < length; k++) {
					if(!validation(set, board[i + k / 3][j + k % 3])) {
						return false;
					}
				}
			}
		}

		return true;
	}

	private static boolean validation(HashSet<Character> set, char c) {
		if (c == '.') {
			return true;
		}

		int num = Character.getNumericValue(c);
		if (num < 1 || num > 9 || set.contains(c)) {
			return false;
		} else {
			set.add(c);
		}

		return true;
	}


    // with one pass 
    // answer from http://www.darrensunny.me/leetcode-valid-sudoku/
    //Since the size of Sudoku board is constant (81 cells), the running time for either algorithm is also constant. 
    //The one-pass algorithm runs faster, while taking up more units of space, than the three-passes one.
	public static boolean isValidSudoku2(char[][] board) {
		// rowChecker[i][j]=true: j appears in row i
		boolean[][] rowChecker = new boolean[9][9];
    	// columnChecker[i][j]=true: j appears in column i
		boolean[][] columnChecker = new boolean[9][9];
    	// gridChecker[i][j]=true: j appears in grid i
    	// numberring from left to right, then top to bottom
		boolean[][] gridChecker = new boolean[9][9];

    	// One-pass scan in row-major manner
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') continue;

				int val = board[i][j] - '1';

				System.out.println(val);

            	// Check for the corresponding row, column, and grid at the same time
				if (rowChecker[i][val] || columnChecker[j][val] || gridChecker[i/3*3+j/3][val])
					return false;

				rowChecker[i][val] = columnChecker[j][val] = gridChecker[i/3*3+j/3][val] = true;
			}
		}

		return true;
	}
}