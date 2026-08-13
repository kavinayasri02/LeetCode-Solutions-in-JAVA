class Solution {
    public int maxPower(String s) {
        int maxLen = 0;
        int currentLen = 0;
        char prev = ' ';
        for(int i =0;i<s.length();i++){
            char curr = s.charAt(i);
            if(curr == prev){
                currentLen++;
            }else{
                currentLen = 1;
                prev = curr;
            }
            maxLen = Math.max(maxLen , currentLen);
        }
        return maxLen;
    }
}