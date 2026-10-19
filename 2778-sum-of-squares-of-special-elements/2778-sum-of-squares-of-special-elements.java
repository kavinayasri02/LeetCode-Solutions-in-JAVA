class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int s = 0;
        for(int i=0;i<n;i++){
            int pos = i+1;
            if(n%pos==0){
                s+=nums[i]*nums[i];
            }
        }
        return s;
    }
}