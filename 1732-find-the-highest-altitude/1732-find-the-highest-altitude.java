class Solution {
    public int largestAltitude(int[] gain) {
        int m = 0;
        int c = 0;
        for(int i=0;i<gain.length;i++){
            c+=gain[i];
            m = Math.max(m,c);
        }
        return m;
    }
}