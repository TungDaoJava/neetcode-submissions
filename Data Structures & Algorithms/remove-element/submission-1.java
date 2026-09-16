class Solution {
    public int removeElement(int[] nums, int val) {
        int pointerLeft = 0;
        int pointerRight = nums.length - 1;
        while (pointerLeft <= pointerRight){
            // 1. Move pointer Right until meet value != val
            while (pointerLeft <= pointerRight && nums[pointerRight] == val){
                pointerRight--;
            }

            // 2. Move pointer left until meet value == val
            while (pointerLeft <= pointerRight && nums[pointerLeft] != val){
                pointerLeft++;
            }

            // 3. Swap ?
            if (pointerLeft < pointerRight){
                int temp = nums[pointerLeft];
                nums[pointerLeft] = nums[pointerRight];
                nums[pointerRight] = temp;

                pointerLeft++;
                pointerRight--;
            }
        }

        return pointerLeft;
    }
}