import java.util.HashSet;
import java.util.List;
import java.util.Set;
class Solution {
    public int sumCounts(List<Integer> nums) {
        int totalSum = 0;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            Set<Integer> de = new HashSet<>();
            for (int j = i; j < n; j++) {
                de.add(nums.get(j)); // HashSet automatically ignores duplicates
                
                int dc = de.size();
                totalSum += dc * dc;
            }
        }
        return totalSum;
    }
}