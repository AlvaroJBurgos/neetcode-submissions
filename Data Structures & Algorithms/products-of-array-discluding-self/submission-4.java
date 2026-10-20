class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] solution = new int[nums.length];
        solution[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int prev = solution[i - 1];
            solution[i] = nums[i - 1] * prev;
        }
        int suffix = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix *= nums[i+1];
            solution[i] = solution[i] * suffix;
        }
        return solution;
    }
}

