class Solution {
    public int minChanges(String s) {
        int c = 0;
        for (int i = 0; i < s.length(); i += 2) {
            // If the adjacent characters in the pair do not match, 1 change is needed
            if (s.charAt(i) != s.charAt(i + 1)) {
                c++;
            }
        }
        return c;
    }
}