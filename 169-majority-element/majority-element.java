// Given an array of size n, find the majority element. The majority element is the element that appears more than &lfloor; n/2 &rfloor; times.
//
// You may assume that the array is non-empty and the majority element always exist in the array.
//
// Credits:Special thanks to @ts for adding this problem and creating all test cases.


public class Solution {
    public int majorityElement(int[] nums) {
        if(nums==null||nums.length<=0)return 0;
        int n = nums[0];
        int num = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==n){
                num++;
            }else{
                num--;
                if(num==0){
                    num =1;
                    n=nums[i];
                }
            }
        }
        return n;
    }
}
