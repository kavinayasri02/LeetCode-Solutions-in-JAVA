public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        
        // If the sum of lengths doesn't match, s3 cannot be an interleave
        if (m + n != s3.length()) {
            return false;
        }
        
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Base case: empty strings interleave to form an empty string
        dp[0][0] = true;
        
        // Fill the first column (using only characters from s1)
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        
        // Fill the first row (using only characters from s2)
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        
        // Fill the rest of the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // Current character in s3 we are looking to match
                int k = i + j - 1; 
                
                // Check if current char matches s1 or s2 and the previous state was valid
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(k)) ||
                           (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(k));
            }
        }
        
        return dp[m][n];
    }
}
