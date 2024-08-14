//use a hashmap
//iterate through the array once - the elements in the nums array serve as the key, and their respective indexes are the values.
//iterate through the array again. This time, check if the hashmap contains the target - current element. If it does, output the indexes of both of these elements.

import java.util.HashMap;

class Solution {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++){
			map.put(nums[i], i);
		}
		for(int j = 0; j < nums.length; j++){
			if(map.containsKey(target - nums[j]) && map.get(target - nums[j]) != j) return new int[]{j, map.get(target - nums[j])};
		}
		return null;
	}
}