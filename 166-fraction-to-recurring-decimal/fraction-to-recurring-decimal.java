// Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
//
// If the fractional part is repeating, enclose the repeating part in parentheses.
//
// For example,
//
// Given numerator = 1, denominator = 2, return "0.5".
// Given numerator = 2, denominator = 1, return "2".
// Given numerator = 2, denominator = 3, return "0.(6)".
//
//
//
//
//   No scary math, just apply elementary math knowledge. Still remember how to perform a long division?
//   Try a long division on 4/9, the repeating part is obvious. Now try 4/333. Do you see a pattern?
//   Be wary of edge cases! List out as many test cases as you can think of and test your code thoroughly.
//
//
// Credits:Special thanks to @Shangrila for adding this problem and creating all test cases.


public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0)return "0";
        StringBuilder sb = new StringBuilder();
        sb.append((numerator>0^denominator>0)?"-":"");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        sb.append(num/den);
        num = num%den;
        if(num==0)return sb.toString();
        sb.append(".");
        Map<Long,Integer>map = new HashMap<>();
        map.put(num,sb.length());
        while(num!=0){
            num*=10;
            sb.append(num/den);
            num = num%den;
            if(map.containsKey(num)){
                sb.insert(map.get(num),"(");
                sb.append(")");
                break;
            }else{
                map.put(num,sb.length());
            }
        }
        return sb.toString();
    }
}
