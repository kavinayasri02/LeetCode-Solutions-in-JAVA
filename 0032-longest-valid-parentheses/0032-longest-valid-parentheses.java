class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;

        int left = 0, right = 0;
        int maxLen = 0;

        // Pass 1: Left-to-right scan
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxLen = Math.max(maxLen, 2 * right);
            } else if (right > left) {
                // Reset counters if we have more close brackets than open ones
                left = 0;
                right = 0;
            }
        }

        left = 0;
        right = 0;

        // Pass 2: Right-to-left scan
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            } else if (left > right) {
                // Reset counters if we have more open brackets than close ones
                left = 0;
                right = 0;
            }
        }

        return maxLen;
    }
}
