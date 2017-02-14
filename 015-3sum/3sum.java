// Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
// Note: The solution set must not contain duplicate triplets.
//
//
// For example, given array S = [-1, 0, 1, 2, -1, -4],
//
// A solution set is:
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
// ]


public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums==null||nums.length<=2)return list;
        Arrays.sort(nums);
        for(int i=0;i<=nums.length-3;i++){
            if(i!=0&&nums[i]==nums[i-1])continue;
            int left = -nums[i];
            int m = i+1,n = nums.length-1;
            while(m<n){
                 if(nums[m]+nums[n]==left){
                    List<Integer>l =  new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[m]);
                    l.add(nums[n]);
                    list.add(l);
                    while(true){
                        m++;
                        if(m==nums.length-1||nums[m]!=nums[m-1])break;
                    }
                    while(true){
                        n--;
                        if(n==0||nums[n]!=nums[n+1])break;
                    }
                  }else if(nums[m]+nums[n]<left){
                     while(true){
                        m++;
                        if(m==nums.length-1||nums[m]!=nums[m-1])break;
                    }
                  }else{
                      while(true){
                        n--;
                        if(n==0||nums[n]!=nums[n+1])break;
                    }
                  }
            }
        }
        return list;
    }
}
