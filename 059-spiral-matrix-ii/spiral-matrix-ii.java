// Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
//
//
// For example,
// Given n = 3,
//
// You should return the following matrix:
//
// [
//  [ 1, 2, 3 ],
//  [ 8, 9, 4 ],
//  [ 7, 6, 5 ]
// ]


public class Solution {
    int[][]result;
    int now;
    public int[][] generateMatrix(int n) {
        result = new int[n][n];
        if(n<=0)return result;
        now=1;
        int x=0,y=0,x_=n-1,y_=n-1;
        while(x<=x_&&y<=y_)
        add(x++,x_--,y++,y_--);
        return result;
    }
    public void add(int x,int x_,int y,int y_){
        if(x==x_&&y==y_)result[x][y]=now;
        else {
            for(int i=y;i<=y_;i++)result[x][i] = now++;
            for(int i=x+1;i<=x_;i++)result[i][y_] = now++;
            for(int i=y_-1;i>=y;i--)result[x_][i] = now++;
            for(int i=x_-1;i>=x+1;i--)result[i][y] = now++;
        }
    }
}
