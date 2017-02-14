// Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
//
//
// For example, given the array [2,3,1,2,4,3] and s = 7,
// the subarray [4,3] has the minimal length under the problem constraint.
//
//
// click to show more practice.
//
// More practice:
//
// If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
//
//
// Credits:Special thanks to @Freezen for adding this problem and creating all test cases.


public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null||nums.length==0)return 0;
        int low = 0,high=0;
        int len = Integer.MAX_VALUE,total = nums[low];
        while(low<=high&&high<nums.length){
            if(total<s){
                high++;
                if(high>=nums.length)break;
                total+=nums[high];
            }else{
                if(high==low)return 1;
                len = Math.min(len,high-low+1);
                total-=nums[low];
                low++;
            }
        }
        return len==Integer.MAX_VALUE?0:len;
    }
}
