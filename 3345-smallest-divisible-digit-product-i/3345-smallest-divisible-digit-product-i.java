class Solution {
    public int smallestNumber(int n, int t) {
        // Incrementally check numbers starting from n
        while (true) {
            if (getDigitProduct(n) % t == 0) {
                return n;
            }
            n++;
        }
    }
    
    // Helper method to compute the product of digits of a number
    private int getDigitProduct(int num) {
        int product = 1;
        
        while (num > 0) {
            int digit = num % 10;
            product *= digit;
            num /= 10;
        }
        
        return product;
    }
}
