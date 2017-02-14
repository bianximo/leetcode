// Given a 2D board and a word, find if the word exists in the grid.
//
//
// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
//
//
// For example,
// Given board = 
//
// [
//   ['A','B','C','E'],
//   ['S','F','C','S'],
//   ['A','D','E','E']
// ]
//
//
// word = "ABCCED", -> returns true,
// word = "SEE", -> returns true,
// word = "ABCB", -> returns false.


public class Solution {
    public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || board[0].length == 0)
			return false;
		if (word == null || word.equals(""))
			return true;
		int x = board.length, y = board[0].length;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (exist(board, word, i, j, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean exist(char[][] board, String word, int x, int y, int index) {
		if (index == word.length())
			return true;
		if (x < 0 || y < 0 || x >= board.length || y >= board[0].length)
			return false;
		if (board[x][y] == word.charAt(index)) {
			board[x][y]='*';
			boolean flag = exist(board, word, x - 1, y, index + 1)
					|| exist(board, word, x + 1, y, index + 1)
					|| exist(board, word, x, y + 1, index + 1)
					|| exist(board, word, x, y - 1, index + 1);
			if (flag)
				return true;
			else {
				board[x][y]=word.charAt(index);
				return false;
			}
		} else
			return false;
	}
}
