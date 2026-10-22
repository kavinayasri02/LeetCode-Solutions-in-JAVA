class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        
        // Step 1: Find the index where 0 is located
        int zeroIdx = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeroIdx = i;
                break;
            }
        }
        
        // Step 2: Check if the cycle is strictly increasing from zeroIdx
        boolean isCyclicallyIncreasing = true;
        for (int i = 0; i < n; i++) {
            if (nums[(zeroIdx + i) % n] != i) {
                isCyclicallyIncreasing = false;
                break;
            }
        }
        
        // Step 3: Check if the cycle is strictly decreasing from zeroIdx
        boolean isCyclicallyDecreasing = true;
        for (int i = 0; i < n; i++) {
            if (nums[(zeroIdx - i + n) % n] != i) {
                isCyclicallyDecreasing = false;
                break;
            }
        }
        
        // Step 4: Calculate the minimum operations required
        int minOps = Integer.MAX_VALUE;
        
        if (isCyclicallyIncreasing) {
            // Option 1: Rotate Left 'zeroIdx' times to bring 0 to the front
            minOps = Math.min(minOps, zeroIdx);
            // Option 2: Reverse, Rotate, Reverse (moves the other direction around the cycle)
            minOps = Math.min(minOps, n - zeroIdx + 2);
        }
        
        if (isCyclicallyDecreasing) {
            // Option 1: Reverse first, then treat it as a fixed rotation
            minOps = Math.min(minOps, n - zeroIdx);
            // Option 2: Rotate first to put 0 at the end, then reverse
            minOps = Math.min(minOps, zeroIdx + 2);
        }
        
        // If neither pattern matches, it's impossible to sort using only reverse/rotate
        return minOps == Integer.MAX_VALUE ? -1 : minOps;
    }
}
