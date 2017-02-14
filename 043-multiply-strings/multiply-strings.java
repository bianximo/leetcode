// Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
//
// Note:
//
// The length of both num1 and num2 is < 110.
// Both num1 and num2 contains only digits 0-9.
// Both num1 and num2 does not contain any leading zero.
// You must not use any built-in BigInteger library or convert the inputs to integer directly.


public class Solution {
    public String multiply(String num1, String num2) {
        if(num1==null||num1.length()==0||num2==null||num2.length()==0||num1.equals("0")||num2.equals("0"))return "0";
        int m = num1.length(),n = num2.length();
        int[]nums = new int[m+n];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int mul = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int p1 = i+j,p2 = i+j+1;
                int tot = mul+nums[p2];
                nums[p1]+=tot/10;
                nums[p2]=tot%10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i : nums){
            if(!(sb.length()==0&&i==0)){
                sb.append(i);
            }
        }
        return sb.length()==0?"0":sb.toString();
    }
}
