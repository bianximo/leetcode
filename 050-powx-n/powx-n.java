// Implement pow(x, n).


public class Solution {
    public double myPow(double x, int n) {
        if(n==0)return 1;
        if(n==1)return x;
        if(equal(x,0))return 0;
        if(equal(x,1))return x;
        boolean Positive = n>0;
        n = Math.abs(n);
        double re = pow(x,n);
        if(!Positive){
            re = 1.0/re;
        }
        return re;
    }
    
    public boolean equal(double d1,double d2){
        return Double.compare(d1,d2)==0;
    }
    // public double pow(double x,int n){
    //     if(n==0)return 1;
    //   if(n==1){
    //         return x;
    //     }
    //     else{
    //         int a = n>>1;
            
    //         return (n%2)==1?pow(x*x,a)*x:pow(x*x,a);
    //     }
    // }
    public double pow(double x, int n) {
        if(n == 0)
            return 1;
        if(n<0){
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? pow(x*x, n/2) : x*pow(x*x, n/2);
    }
}
