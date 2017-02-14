// Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//
//
//
// For example,
// [1,1,2] have the following unique permutations:
//
// [
//   [1,1,2],
//   [1,2,1],
//   [2,1,1]
// ]


public class Solution {
   
     public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);
    permutating(ans, nums, 0);
    return ans;
}

private void permutating(List<List<Integer>> ans, int[] nums, int start) {
    
	if (start == nums.length) {
		List<Integer> li = new ArrayList<>();
		for (int n : nums) {
			li.add(n);
		}
		ans.add(li);
		return;
	}
	for (int i = start; i < nums.length; i++) {
		if(!canExchange(nums,start,i)){
		  continue;
		}
		swap(nums, start, i);
		permutating(ans, nums, start+1);
		swap(nums, start, i);
	}
}
private boolean canExchange(int[]nums,int start,int i){
        for(int j = start;j<i;j++){
            if(nums[j]==nums[i])return false;
        }
        return true;
}

private void swap(int[] nums, int i, int j) {
	int temp = nums[i];
	nums[i] = nums[j];
	nums[j] = temp;
}
}
