class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    // Helper method to find the first occurrence of the target
    private int findFirst(int[] nums, int target) {
        int index = -1;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] >= target) {
                high = mid - 1; // Keep searching left to find the first position
            } else {
                low = mid + 1;
            }

            if (nums[mid] == target) {
                index = mid; // Record the potential starting index
            }
        }
        return index;
    }

    // Helper method to find the last occurrence of the target
    private int findLast(int[] nums, int target) {
        int index = -1;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] <= target) {
                low = mid + 1; // Keep searching right to find the last position
            } else {
                high = mid - 1;
            }

            if (nums[mid] == target) {
                index = mid; // Record the potential ending index
            }
        }
        return index;
    }
}
