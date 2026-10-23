class Solution {
    public int sortPermutation(int[] nums) {
         int ans = -1; 
        for (int i = 0; i < nums.length; i++) {
            // Check if the current element is misplaced
            if (nums[i] != i) {
                ans &= nums[i];
            }
        }
        return Math.max(ans, 0);
    }
}