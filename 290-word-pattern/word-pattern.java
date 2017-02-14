// Given a pattern and a string str, find if str follows the same pattern.
//  Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
//
// Examples:
//
// pattern = "abba", str = "dog cat cat dog" should return true.
// pattern = "abba", str = "dog cat cat fish" should return false.
// pattern = "aaaa", str = "dog cat cat dog" should return false.
// pattern = "abba", str = "dog dog dog dog" should return false.
//
//
//
//
// Notes:
// You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
//
//
// Credits:Special thanks to @minglotus6 for adding this problem and creating all test cases.


public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(pattern==null||str==null||pattern.equals("")||str.equals(""))return false;
        Map<Character,String>map = new HashMap<>();
        String[]strs = str.split(" ");
        if(pattern.length()!=strs.length)return false;
        boolean flag = true;
        for(int i=0;i<pattern.length();i++){
            if(!map.containsKey(pattern.charAt(i))){
                if(map.containsValue(strs[i])){
                    flag=false;
                    break;
                }
                map.put(pattern.charAt(i),strs[i]);
            }else{
                if(!strs[i].equals(map.get(pattern.charAt(i)))){
                    flag=false;
                    break;
                }
            }
        }
        return flag;
    }
}
