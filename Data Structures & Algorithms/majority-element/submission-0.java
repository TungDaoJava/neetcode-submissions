class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int middle = nums.length / 2;
        return nums[middle];
    }
}