// Rotate an array of n elements to the right by k steps.
// For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]. 
//
// Note:
// Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
//
//
// [show hint]
// Hint:
// Could you do it in-place with O(1) extra space?
//
//
// Related problem: Reverse Words in a String II
//
// Credits:Special thanks to @Freezen for adding this problem and creating all test cases.


public class Solution {
    public void rotate(int[] nums, int k) {
        if(k==0)return ;
        while(k>=nums.length){
            k-=nums.length;
        
        }
        change(nums,0,nums.length-1);
        change(nums,0,k-1);
        change(nums,k,nums.length-1);
        
    }
    public void change(int[]nums,int a,int b){
        if(a>=b)return;
        for(int i=a;i<=(a+b)/2;i++){
            int temp = nums[i];
            nums[i]=nums[b-i+a];
            nums[b-i+a]=temp;
        }
    }
}
