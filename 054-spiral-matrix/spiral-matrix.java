// Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//
//
//
// For example,
// Given the following matrix:
//
//
// [
//  [ 1, 2, 3 ],
//  [ 4, 5, 6 ],
//  [ 7, 8, 9 ]
// ]
//
//
// You should return [1,2,3,6,9,8,7,4,5].


public class Solution {
    public List<Integer>list;
    public List<Integer> spiralOrder(int[][] matrix) {
        list = new ArrayList<>();
        if(matrix ==null||matrix.length==0||matrix[0].length==0)return list;
        
        int startX = 0,startY=0,endX=matrix.length-1,endY=matrix[0].length-1;
        while(startX<=endX&&startY<=endY)add(matrix,startX++,endX--,startY++,endY--);
        return list;
    }
    public void add(int[][]matrix,int startX,int endX,int startY,int endY){
        if(startX==endX&&startY==endY)list.add(matrix[startX][startY]);
        else if(startX==endX){
            for(int i=startY;i<=endY;i++)list.add(matrix[startX][i]);
        }else if(startY==endY){
            for(int i=startX;i<=endX;i++)list.add(matrix[i][startY]);
        }else{
            for(int i=startY;i<=endY;i++){
                list.add(matrix[startX][i]);
            }
            for(int i=startX+1;i<=endX;i++){
                list.add(matrix[i][endY]);
            }
            for(int i=endY-1;i>=startY;i--){
                list.add(matrix[endX][i]);
            }
            for(int i=endX-1;i>=startX+1;i--){
                list.add(matrix[i][startY]);
            }
        }
    }
}
