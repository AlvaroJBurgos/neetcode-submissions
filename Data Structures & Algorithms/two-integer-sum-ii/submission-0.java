class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int j = numbers.length - 1;
        int i = 0;
        int[] result = new int[2];

        while (i < j) {
            int current = numbers[i] + numbers[j];
            if (current == target)
                return new int[] {i + 1, j + 1};
            else if (current < target) {
                i++;
            } else
                j--;
        }
        return result;
    }
}
