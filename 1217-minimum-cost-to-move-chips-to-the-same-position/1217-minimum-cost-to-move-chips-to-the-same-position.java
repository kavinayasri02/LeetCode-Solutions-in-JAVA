class Solution {
    public int minCostToMoveChips(int[] position) {
        int a = 0;
        int b = 0;
        for(int p : position){
            if(p%2==0){
                a++;
            }else{
                b++;
            }
        }return Math.min(a,b);
    }
}