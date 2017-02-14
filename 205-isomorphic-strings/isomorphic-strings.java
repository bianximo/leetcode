// Given two strings s and t, determine if they are isomorphic.
//
// Two strings are isomorphic if the characters in s can be replaced to get t.
//
// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
//
// For example,
// Given "egg", "add", return true.
//
// Given "foo", "bar", return false.
//
// Given "paper", "title", return true.
//
// Note:
// You may assume both s and t have the same length.


public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s==null||t==null||s.length()!=t.length())return false;
        Map<Character,Character>map = new HashMap<>();
        boolean flag = true;
        for(int i=0;i<s.length();i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(!map.containsKey(c1)){
                if(map.containsValue(c2)){
                    flag=false;
                    break;
                }
                map.put(c1,c2);
            }else{
                if(c2!=map.get(c1)){
                    flag=false;
                    break;
                }
            }
        }
        return flag;
    }
}
