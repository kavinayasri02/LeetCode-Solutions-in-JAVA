class Solution {
    public boolean isHappy(int n) {
        int[]seen = new int[1000];
        int count = 0;
        while(n!=1){
            for(int i =0;i<count;i++){
                if(seen[i] == n){
                  return false;
                }
            }
            seen[count] = n;
            count++;
            int totalSum = 0;
            while(n>0){
                int digit = n%10;
                totalSum += digit*digit;
                n=n/10;
            }
            n = totalSum;
        }
        return true;
    }
}