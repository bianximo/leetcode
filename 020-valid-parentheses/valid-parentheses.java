// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
// The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.


public class Solution {
    public boolean isValid(String s) {
        Stack<Character>st = new Stack<>();
        for(char i:s.toCharArray()){
            if(i=='{')st.push('}');
            else if(i=='(')st.push(')');
            else if(i=='[')st.push(']');
            else if(st.isEmpty()||st.pop()!=i)return false;
        }
        return st.isEmpty();
    }
}
