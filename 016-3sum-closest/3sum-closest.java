// Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
//
//
//     For example, given array S = {-1 2 1 -4}, and target = 1.
//
//     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums==null||nums.length<3)return 0;
        Arrays.sort(nums);
        int result = nums[0]+nums[1]+nums[nums.length-1];
        for(int i=0;i<=nums.length-3;i++){
            int a = i+1,b = nums.length-1;
            while(a<b){
                int total = nums[i]+nums[a]+nums[b];
                if(total<target)a++;
                else b--;
                if(Math.abs(result-target)>Math.abs(total-target))result = total;
            }
        }
        return result;
    }
}
