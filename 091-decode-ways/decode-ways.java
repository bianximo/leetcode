// A message containing letters from A-Z is being encoded to numbers using the following mapping:
//
//
//
// 'A' -> 1
// 'B' -> 2
// ...
// 'Z' -> 26
//
//
//
// Given an encoded message containing digits, determine the total number of ways to decode it.
//
//
//
// For example,
// Given encoded message "12",
// it could be decoded as "AB" (1 2) or "L" (12).
//
//
//
// The number of ways decoding "12" is 2.


public class Solution {
    // public int numDecodings(String s) {
    //     if(s==null||s.length()==0)return 0;
    //     char[]string = s.toCharArray();
    //     return count(string,0,string.length-1);
    // }
    // public int count(char[]s,int begin,int end){
    //     if(begin>end)return 1;
    //     if(s[begin]=='0')return 0;
    //     else if(begin==end)return 1;
    //     int res = 0;
    //     res+=count(s,begin+1,end);
    //     if(getNum(s,begin,begin+1)<=26)res+=count(s,begin+2,end);
    //     return res;
    // }
    // public int getNum(char[]s,int begin,int end){
    //     int res = 0;
    //     for(int i=begin;i<=end;i++){
    //         res = res*10+s[i]-'0';
    //     }
    //     return res;
    // }
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[]dp = new int[len+1];
        dp[0] = 1;
        dp[1] = s.charAt(0)=='0'?0:1;
        for(int i=2;i<=len;i++){
            int first = Integer.parseInt(s.substring(i-1,i));
            int second = Integer.parseInt(s.substring(i-2,i));
            if(first<=9&&first>=1)dp[i]+=dp[i-1];
            if(second<=26&&second>=10)dp[i]+=dp[i-2];
        }
        return dp[len];
    }
}
