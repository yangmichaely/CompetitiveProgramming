//two pointer - counter is placed at the first element, and only increments when a value different from val is found and used to replace the current element at counter's position.

class Solution {
	public int removeElement(int[] nums, int val) {
		int count = 0;
		for(int i = 0; i<nums.length; i++){
			if(nums[i]!=val){
				nums[count]=nums[i];
				count++;
			}
		}
		return count;
	}
}