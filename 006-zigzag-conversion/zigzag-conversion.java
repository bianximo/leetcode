// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
//
// P   A   H   N
// A P L S I I G
// Y   I   R
//
//
// And then read line by line: "PAHNAPLSIIGYIR"
//
//
// Write the code that will take a string and make this conversion given a number of rows:
//
// string convert(string text, int nRows);
//
// convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".


public class Solution {
    public String convert(String s, int numRows) {
        if(s==null||s.length()==0||numRows==1||s.length()<=numRows)return s;
        StringBuilder[]sbs = new StringBuilder[numRows];
         for(int i=0;i<sbs.length;i++)sbs[i] = new StringBuilder();
        for(int i=0;i<s.length();i++){
            int index = -1,flag = i%((numRows-1)*2);
            for(int j = 0;j<numRows;j++){
                if(flag==j||flag==(numRows-1)*2-j)index = j;
            }
            sbs[index].append(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<sbs.length;i++)sb.append(sbs[i].toString());
        return sb.toString();
    }
}
