// Divide two integers without using multiplication, division and mod operator.
//
//
// If it is overflow, return MAX_INT.


public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor==0||dividend==Integer.MIN_VALUE&&divisor==-1)return Integer.MAX_VALUE;
       int negative = ((dividend>0)^(divisor>0))?-1:1;
       long de = Math.abs((long)dividend);
       long di = Math.abs((long)divisor);
       int result = 0;
       while(de>=di){
           long temp = di;
           int mul = 1;
           while(de>= (temp<<1)){
               temp = temp<<1;
               mul = mul<<1;
           }
           de = de-temp;
           result+=mul;
       }
       return negative>0?result:-result;
    }
}
