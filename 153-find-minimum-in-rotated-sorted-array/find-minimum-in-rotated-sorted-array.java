// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
// Find the minimum element.
//
// You may assume no duplicate exists in the array.


public class Solution {
    public int findMin(int[] nums) {
        if(nums==null||nums.length<=0)return -1;
        if(nums[0]<nums[nums.length-1])return nums[0];
        int begin = 0;
        int end = nums.length-1;
        while((end-begin)>1){
            int mid = (end+begin)/2;
            if(nums[mid]>nums[begin])begin = mid;
            else if(nums[mid]<nums[end])end = mid;
        }
        return nums[end];
    }
}
