// Given an integer array of size n, find all elements that appear more than &lfloor; n/3 &rfloor; times. The algorithm should run in linear time and in O(1) space.
//
//
//   How many majority elements could it possibly have?
//   Do you have a better hint? Suggest it!


public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // Map<Integer,Integer>map = new HashMap<>();
        // List<Integer>list = new ArrayList<>();
        // for(int i=0;i<nums.length;i++){
        //     if(!map.containsKey(nums[i])){
        //         map.put(nums[i],1);
        //     }else{
        //         Integer t = map.get(nums[i]);
        //         map.put(nums[i],t+1);
        //     }
        // }
        // for(Integer i : map.keySet()){
        //     if(map.get(i)>nums.length/3){
        //         list.add(i);
        //     }
        // }
        // return list;
        List<Integer>list = new ArrayList<>();
        if(nums==null||nums.length==0)return list;
        if(nums.length==1){
            list.add(nums[0]);
            return list;
        }
        int count1=0,count2=0,num1=nums[0],num2=nums[1];
        for(int i=0;i<nums.length;i++){
            if(nums[i]==num1)count1++;
            else if(nums[i]==num2)count2++;
            else if(count1==0){
                num1=nums[i];
                count1=1;
            }else if(count2==0){
                num2=nums[i];
                count2=1;
            }else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
	    count2 = 0;
	    for (int i = 0; i < nums.length; i++) {
		    if (nums[i] == num1)
			    count1++;
		    else if (nums[i] == num2)
			    count2++;
	    }
	    if (count1 > nums.length / 3)
	    	list.add(num1);
    	if (count2 > nums.length / 3)
	    	list.add(num2);
        return list;
    }
}
