// Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:
//
//
// You receive a valid board, made of only battleships or empty slots.
// Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
// At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
//
//
// Example:
// X..X
// ...X
// ...X
//
// In the above board there are 2 battleships.
//
// Invalid Example:
// ...X
// XXXX
// ...X
//
// This is an invalid board that you will not receive - as battleships will always have a cell separating between them.
//
// Follow up:Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board?


public class Solution {
    public int countBattleships(char[][] board) {
        int n = board[0].length;//列
        int m = board.length;//行
        int num = 0;
        int[][]visited = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==0&&board[i][j]=='X'){
                    num++;
                    dfs(board,visited,i,j);
                }
            }
        }
        return num;
    }
    private void dfs(char[][]board,int[][]visited,int i,int j){
        visited[i][j]=1;
        int n = board[0].length;//列
        int m = board.length;//行
        if(i>0&&visited[i-1][j]==0&&board[i-1][j]=='X'){
            dfs(board,visited,i-1,j);
        }if(i<m-1&&visited[i+1][j]==0&&board[i+1][j]=='X'){
             dfs(board,visited,i+1,j);
        }if(j>0&&visited[i][j-1]==0&&board[i][j-1]=='X'){
             dfs(board,visited,i,j-1);
        }if(j<n-1&&visited[i][j+1]==0&&board[i][j+1]=='X'){
             dfs(board,visited,i,j+1);
        }
    }
}
