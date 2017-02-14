// Given an input string, reverse the string word by word.
//
//
//
// For example,
// Given s = "the sky is blue",
// return "blue is sky the".
//
//
//
// Update (2015-02-12):
// For C programmers: Try to solve it in-place in O(1) space.
//
//
// click to show clarification.
//
// Clarification:
//
//
//
// What constitutes a word?
// A sequence of non-space characters constitutes a word.
// Could the input string contain leading or trailing spaces?
// Yes. However, your reversed string should not contain leading or trailing spaces.
// How about multiple spaces between two words?
// Reduce them to a single space in the reversed string.


public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        if(s==null||s.length()<=1)return s;
        StringBuilder sb = new StringBuilder();
        char[]string = s.toCharArray();
        reverse(string,0,string.length-1);
        int i=0,len=0;
        while(i+len<string.length){
            while(i+len<string.length&&string[i+len]!=' ')len++;
            reverse(string,i,i+len-1);
            sb.append(string,i,len).append(' ');
            while(i+len<string.length&&string[i+len]==' ')len++;
            i = i+len;
            len = 0;
        }
        if(sb.length()>0)sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    public void reverse(char[]string,int begin,int end){
        while(begin<end){
            char temp = string[begin];
            string[begin] = string[end];
            string[end] = temp;
            begin++;
            end--;
        }
    }
}
