// Implement a basic calculator to evaluate a simple expression string.
//
// The expression string contains only non-negative integers, +, -, *, / operators and empty spaces  . The integer division should truncate toward zero.
//
// You may assume that the given expression is always valid.
//
// Some examples:
//
// "3+2*2" = 7
// " 3/2 " = 1
// " 3+5 / 2 " = 5
//
//
//
//
// Note: Do not use the eval built-in library function.
//
//
// Credits:Special thanks to @ts for adding this problem and creating all test cases.


public class Solution {
    public int calculate(String s) {
        if(s==null||s.length()==0)return 0;
        char sign = '+';
        Stack<Integer>stack = new Stack<>();
        int num = 0;
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i)))num = num*10+s.charAt(i)-'0';
            if(!Character.isDigit(s.charAt(i))&&s.charAt(i)!=' '||i==s.length()-1){
                if(sign=='+')stack.push(num);
                else if(sign=='-')stack.push(-num);
                else if(sign=='*')stack.push(num*stack.pop());
                else stack.push(stack.pop()/num);
                num = 0;
                sign = s.charAt(i);
            }
        }
        int res = 0;
        for(int i:stack)res+=i;
        return res;
    }
}
