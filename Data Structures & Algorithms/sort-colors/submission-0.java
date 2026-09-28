class Solution {
    public void sortColors(int[] nums) {
        int zeroPointer = 0;
        int twoPointer = nums.length - 1;
        while (zeroPointer < twoPointer && nums[zeroPointer] == 0){
            zeroPointer++;
        }

        while (zeroPointer < twoPointer && nums[twoPointer] == 2){
            twoPointer--;
        }

        if (zeroPointer >= twoPointer){
            return;
        }

        int middlePointer = zeroPointer;

        while (middlePointer <= twoPointer){
            if (nums[middlePointer] == 0){
                swap(nums, middlePointer, zeroPointer);
                middlePointer++;
                zeroPointer++;
            } else if (nums[middlePointer] == 2){
                swap(nums, middlePointer, twoPointer);
                twoPointer--;
            } else {
                middlePointer++;
            }

        }
    }

    private void swap(int[] nums, int pointerOne, int pointerTwo){
        int temp = nums[pointerOne];
        nums[pointerOne] = nums[pointerTwo];
        nums[pointerTwo] = temp;
    }
}