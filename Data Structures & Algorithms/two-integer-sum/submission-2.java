class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++){
            if (cache.containsKey(target - nums[i])){
                result[0] = cache.get(target - nums[i]);
                result[1] = i;
                break;
            }

            cache.put(nums[i], i);
        }
        return result;
    }
}
