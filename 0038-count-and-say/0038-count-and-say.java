class Solution {
    public String countAndSay(int n) {
       String c = "1";
        for (int step = 1; step < n; step++) {
            StringBuilder next = new StringBuilder();
            int i = 0;
            while (i < c.length()) {
                char digit = c.charAt(i);
                int count = 0;
                while (i < c.length() && c.charAt(i) == digit) {
                    count++;
                    i++;
                }
                next.append(count).append(digit);
            } 
            c = next.toString();
        }
        return c; 
    }
}