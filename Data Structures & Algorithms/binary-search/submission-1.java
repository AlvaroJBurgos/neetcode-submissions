class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;
            int value = nums[middle];
            if (value == target) {
                return middle;
            } else

                if (value > target) {
                end = middle - 1;

            } else

                if (value < target) {
                start = middle + 1;
            }
        }
        return -1;
    }
}
