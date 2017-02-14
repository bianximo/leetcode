// Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
//
//
// For example: 
// Given n = 13,
// Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
//
//
//
//   Beware of overflow.


public class Solution {
    public int countDigitOne(int n) {
        if(n<=0)return 0;
        Long total = 0L;
        Long base = 1L;
        while(base<=n){
            long now = (n/base)%10;
            long low = n-(n/base)*base;
            long high = n/base/10;
            if(now>1){
                total = total+base*(high+1);
            }else if(now==1){
                total = total+base*high+low+1;
            }else {
                total = total+high*base;
            }
                base = base*10;
        }
        if(total>Integer.MAX_VALUE)return Integer.MAX_VALUE;
        return total.intValue();
    }
}
