class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int c = 0;
        int tc = 0;
        for(int num : nums){
            if(num < target){
            c++;
        }else if(num == target){
            tc++;
        }
    }
    List<Integer> res = new ArrayList<>();
    for(int i=0;i<tc;i++){
        res.add(c+i);
    }
    return res;
}
}