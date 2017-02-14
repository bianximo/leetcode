// Find the contiguous subarray within an array (containing at least one number) which has the largest product.
//
//
//
// For example, given the array [2,3,-2,4],
// the contiguous subarray [2,3] has the largest product = 6.


public class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null||nums.length==0)return 0;
        int max=nums[0];
        int maxpre=nums[0],minpre=nums[0],maxhere,minhere;
        for(int i=1;i<nums.length;i++){
            maxhere=Math.max(Math.max(maxpre*nums[i],minpre*nums[i]),nums[i]);
            minhere=Math.min(Math.min(maxpre*nums[i],minpre*nums[i]),nums[i]);
            
            maxpre=maxhere;
            minpre=minhere;
            max = Math.max(max,maxhere);
            
        }
        return max;
    }
}
