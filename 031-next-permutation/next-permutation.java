// Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
//
// If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//
//
// The replacement must be in-place, do not allocate extra memory.
//
//
// Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
// 1,2,3 &#8594; 1,3,2
// 3,2,1 &#8594; 1,2,3
// 1,1,5 &#8594; 1,5,1


public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums==null||nums.length<=1)return;
        
        int i,index = 0,lastIndex=0;
        for(i=nums.length-1;i>=1;i--){
            if(nums[i]>nums[i-1]){
                index = i;
                break;
            }
        }
        if(i==0){
            reverse(nums,0,nums.length-1);
            return;
        }
        int data = nums[index-1];
        for(i=nums.length-1;i>=index;i--){
            if(nums[i]>data){
                lastIndex = i;
                break;
            }
        }
        swap(nums,index-1,lastIndex);
        reverse(nums,index,nums.length-1);
    }
    public void swap(int[]nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse(int[]nums,int m,int n){
        while(m<n){
            swap(nums,m++,n--);
        }
    }
}
