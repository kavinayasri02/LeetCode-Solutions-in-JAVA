class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long ab = lcm(a, b);
        long ac = lcm(a, c);
        long bc = lcm(b, c);
        long abc = lcm(ab, c);
        
        long low = 1;
        long high = 2_000_000_000L; // Max possible value given constraints
        long ans = low;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long count = (mid / a) + (mid / b) + (mid / c)- (mid / ab) - (mid / ac) - (mid / bc)+ (mid/abc);
                       
            if (count >= n) {
                ans = mid;         // Found a candidate, try to see if a smaller one works
                high = mid - 1;
            } else {
                low = mid + 1;     // Not enough ugly numbers, search higher
            }
        }
        
        return (int) ans;
    }
    
    // Greatest Common Divisor
    private long gcd(long x, long y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }
    
    // Least Common Multiple (Divide before multiplying to prevent premature overflow)
    private long lcm(long x, long y) {
        return (x / gcd(x, y)) * y;
    }
}
