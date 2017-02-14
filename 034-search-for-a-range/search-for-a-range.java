// Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
//
// Your algorithm's runtime complexity must be in the order of O(log n).
//
// If the target is not found in the array, return [-1, -1].
//
//
// For example,
// Given [5, 7, 7, 8, 8, 10] and target value 8,
// return [3, 4].


public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[]result = {-1,-1};
        if(nums==null||nums.length==0)return result;
        int begin = findbegin(nums,target,0,nums.length-1);
        int end = findend(nums,target,0,nums.length-1);
        result[0] = nums[begin]==target?begin:-1;
        result[1] = nums[end]==target?end:-1;
        return result;
    }
    public int findbegin(int[]nums,int target,int low,int high){
        int begin = low;
        int end = high;
        while(begin<end){
            int mid = (begin+end)/2;
            if(nums[mid]<target)begin = mid+1;
            else if(nums[mid]>target)end = mid-1;
            else if(mid!=0&&nums[mid-1]==nums[mid])end = mid-1;
            else return mid;
        }
        return begin;
    }  
    public int findend(int[]nums,int target,int low,int high){
        int begin = low;
        int end = high;
        while(begin<end){
            int mid = (begin+end)/2;
            if(nums[mid]<target)begin = mid+1;
            else if(nums[mid]>target)end = mid-1;
            else if(mid!=nums.length-1&&nums[mid+1]==nums[mid])begin = mid+1;
            else return mid;
        }
        return begin;
    }
}
