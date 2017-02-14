// Given a digit string, return all possible letter combinations that the number could represent.
//
//
//
// A mapping of digit to letters (just like on the telephone buttons) is given below.
//
//
//
// Input:Digit string "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//
//
//
// Note:
// Although the above answer is in lexicographical order, your answer could be in any order you want.


public class Solution {
    List<String>list;
    char[][]form = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},
    {'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    public List<String> letterCombinations(String digits) {
        list = new ArrayList<>();
        if(digits==null||digits.length()==0)return list;
        combine(digits,new StringBuilder(),0);
        return list;
    }
    public void combine(String digits,StringBuilder sb,int index){
        if(index==digits.length()){
            list.add(sb.toString());
            return;
        }
        char[]array = form[digits.charAt(index)-'0'];
        for(char c:array){
            sb.append(c);
            combine(digits,sb,index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
