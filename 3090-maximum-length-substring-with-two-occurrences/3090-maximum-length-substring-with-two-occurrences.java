class Solution {
    public int maximumLengthSubstring(String s) {
        int max = 0 ;
        for(int i =0;i<s.length();i++){
            int[] arr = new int[26];
            for(int j =i;j<s.length();j++){
                char ch = s.charAt(j);
                arr[ch - 'a']++;
                if(arr[ch - 'a'] > 2){
                    break;
                }
                max = Math.max(max , j - i+1);
            }
        }
        return max;
    }
}