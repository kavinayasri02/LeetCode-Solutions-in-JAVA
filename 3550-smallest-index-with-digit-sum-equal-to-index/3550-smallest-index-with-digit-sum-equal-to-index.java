class Solution {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (getDigitSum(nums[i]) == i) {
                return i; // Return immediately for the smallest index
            }
        }
        return -1;
    }
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10; // Extract the last digit
            num /= 10;       // Remove the last digit
        }
        return sum;
    }
}