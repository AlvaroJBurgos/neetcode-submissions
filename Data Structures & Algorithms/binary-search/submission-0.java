class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        // int middle = (start + end) / 2;
        // int value = nums[middle];
        // int index = -1;

        while (start <= end) {
            int middle = (start + end) / 2;
            int value = nums[(start + end) / 2];
            if (value == target) {
                return middle;
            } else

                if (value > target) {
                end = middle - 1;
                // middle = (start + end) / 2;
                // value = nums[middle];
            } else

                if (value < target) {
                start = middle + 1;
                // middle = (start + end) / 2;
                // value = nums[middle];
            }
        }
        return -1;
    }
}
