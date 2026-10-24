import java.util.HashSet;
import java.util.Set;
class Solution {
    public int missingInteger(int[] nums) {
        // Step 1: Calculate the sum of the longest sequential prefix starting at index 0
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // Check if the current element continues the sequential chain
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                // Break immediately at the first gap in sequence
                break; 
            }
        }
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        while (numSet.contains(sum)) {
            sum++;
        }
        return sum;
    }
}
