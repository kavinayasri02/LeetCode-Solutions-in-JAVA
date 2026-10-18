class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int prev2 = 1; // dp[i - 2]
        int prev1 = 1; // dp[i - 1]
        for (int i = 1; i < s.length(); i++) {
            int curr = 0;
            int single = s.charAt(i) - '0';
            if (single >= 1) {
                curr += prev1;
            }
            int twoDigit = (s.charAt(i - 1) - '0') * 10 + single;
            if (twoDigit >= 10 && twoDigit <= 26) {
                curr += prev2;
            }
            if (curr == 0) return 0; // Early termination for invalid prefix
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}