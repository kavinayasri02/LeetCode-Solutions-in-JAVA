import java.util.*;
class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        // Pair structure to store the number and its original index
        Element[] elements = new Element[n];
        for (int i = 0; i < n; i++) {
            elements[i] = new Element(nums[i], i, getDigitSum(nums[i]));
        }
        Arrays.sort(elements, (a, b) -> {
            if (a.digitSum != b.digitSum) {
                return Integer.compare(a.digitSum, b.digitSum);
            }
            return Integer.compare(a.val, b.val);
        });
        boolean[] visited = new boolean[n];
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            // If already visited or already in the correct position, skip
            if (visited[i] || elements[i].originalIndex == i) {
                continue;
            }
            int cycleSize = 0;
            int currIndex = i;
            
            while (!visited[currIndex]) {
                visited[currIndex] = true;
                // Move to the position where this element originally came from
                currIndex = elements[currIndex].originalIndex;
                cycleSize++;
            }
            
            // A cycle of size K requires exactly (K - 1) swaps to fix
            if (cycleSize > 0) {
                swaps += (cycleSize - 1);
            }
        }
        return swaps;
    }
    
 private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    
    // Internal helper class to track items cleanly
    private static class Element {
        int val;
        int originalIndex;
        int digitSum;
        
        Element(int val, int originalIndex, int digitSum) {
            // Direct assignment without structural overhead
            this.val = val;
            this.originalIndex = originalIndex;
            this.digitSum = digitSum;
        }
    }
}
