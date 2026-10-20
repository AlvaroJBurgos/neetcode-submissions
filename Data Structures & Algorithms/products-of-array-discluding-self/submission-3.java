class Solution {
    public int[] productExceptSelf(int[] nums) {
        int result = 1;
        boolean hasZero = false;
        int[] solution = new int[nums.length];
        for (int num : nums) {
            if (num == 0 && !hasZero) {
                hasZero = true;
                continue;
            }
            result *= num;
        }
        for (int i = 0; i < nums.length; i++) {
            solution[i] = result;
            if (hasZero && nums[i] != 0)
                solution[i] = 0;
            else if (nums[i] == 0)
                solution[i] = result;
            else
                solution[i] = result / nums[i];
        }
        return solution;
    }
}

