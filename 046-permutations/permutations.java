// Given a collection of distinct numbers, return all possible permutations.
//
//
//
// For example,
// [1,2,3] have the following permutations:
//
// [
//   [1,2,3],
//   [1,3,2],
//   [2,1,3],
//   [2,3,1],
//   [3,1,2],
//   [3,2,1]
// ]


public class Solution {
        List<List<Integer>> list;
    public List<List<Integer>> permute(int[] nums) {
        list = new ArrayList<>();
        if(nums==null||nums.length==0)return list;
        Arrays.sort(nums);
        permute(nums,0);
        return list;
    }
    public void permute(int[]nums,int index){
        if(index==nums.length-1){
            List<Integer>l = new ArrayList<>();
            for(int i:nums)l.add(i);
            list.add(l);
        }
        for(int i=index;i<nums.length;i++){
            swap(nums,index,i);
            permute(nums,index+1);
            swap(nums,index,i);
        }
    }
    public void swap(int[]nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
