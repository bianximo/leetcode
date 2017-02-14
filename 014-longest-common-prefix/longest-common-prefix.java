// Write a function to find the longest common prefix string amongst an array of strings.


public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0)return "";
        int minLen = Integer.MAX_VALUE,len = 0;
        for(String s:strs)minLen = Math.min(s.length(),minLen);
        for(int i=0;i<minLen;i++){
            if(equalChar(strs,strs[0].charAt(i),i))len++;
            else break ;
        }
        return strs[0].substring(0,len);
    }
    public boolean equalChar(String[]strs,char c,int index){
        for(String s:strs)if(s.charAt(index)!=c)return false;
        return true;
    }
}
