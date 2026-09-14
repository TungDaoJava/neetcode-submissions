class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> memory = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            if (!memory.add(nums[i])){
                return true;
            }
        }

        return false;
    }
}