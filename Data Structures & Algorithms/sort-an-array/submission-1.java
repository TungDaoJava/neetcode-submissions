class Solution {
    public int[] sortArray(int[] nums) {
        sort(0, nums.length - 1, nums);
        return nums;
    }

    private void sort(int beginIndex, int endIndex, int[] nums){
        if (beginIndex >= endIndex){
            return;
        }
        int leftPtr = beginIndex;
        int rightPtr = endIndex;
        int middlePtr = beginIndex + (endIndex - beginIndex) / 2;

        int middleVal = nums[middlePtr];
        while (leftPtr <= rightPtr){
            while (leftPtr <= rightPtr && nums[leftPtr] < middleVal){
                leftPtr++;
            }

            while (leftPtr <= rightPtr && nums[rightPtr] > middleVal){
                rightPtr--;
            }

            if (leftPtr <= rightPtr){
                swap(leftPtr, rightPtr, nums);
                leftPtr++;
                rightPtr--;
            }
        }

        if (beginIndex < rightPtr) sort(beginIndex, rightPtr, nums);
        if (leftPtr < endIndex) sort(leftPtr, endIndex, nums);
    }

    private void swap(int idx1, int idx2, int[] nums){
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}