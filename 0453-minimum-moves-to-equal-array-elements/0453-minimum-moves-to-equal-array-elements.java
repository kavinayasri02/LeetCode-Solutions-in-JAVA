public class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
      // 1. Find the minimum element in the array
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }
        int moves = 0;
        for (int num : nums) {
            moves += (num - min);
        }
        
        return moves;
    }
}
