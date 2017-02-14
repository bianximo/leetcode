// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
//
//
// For example,
// "A man, a plan, a canal: Panama" is a palindrome.
// "race a car" is not a palindrome.
//
//
//
// Note:
// Have you consider that the string might be empty? This is a good question to ask during an interview.
//
// For the purpose of this problem, we define empty string as valid palindrome.


public class Solution {
    public boolean isPalindrome(String s) {
        if(s==null||s.length()==0)return true;
        s = s.trim();
        char[]chars = s.toCharArray();
        int low = 0,high=chars.length-1;
        while(low<high){
            while(low<chars.length&&!('a'<=chars[low]&&chars[low]<='z'||'A'<=chars[low]&&chars[low]<='Z'||'0'<=chars[low]&&chars[low]<='9'))low++;
            while(high>=0&&!('a'<=chars[high]&&chars[high]<='z'||'A'<=chars[high]&&chars[high]<='Z'||'0'<=chars[high]&&chars[high]<='9'))high--;
            if(low<high){
                if(chars[low]!=chars[high]&&Character.toUpperCase(chars[low])!=Character.toUpperCase(chars[high]))return false;
                low++;
                high--;
            }else return true;
        }
        return true;
    }
}
