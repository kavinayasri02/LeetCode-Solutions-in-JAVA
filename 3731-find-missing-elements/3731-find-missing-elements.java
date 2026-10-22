import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> pn = new HashSet<>();
        
        // Find boundaries and record present numbers
        for (int num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
            pn.add(num);
        }
        
        List<Integer> ms = new ArrayList<>();
        // Iterate through the full range and pick missing elements
        for (int i = min + 1; i < max; i++) {
            if (!pn.contains(i)) {
                ms.add(i);
            }
        }
        
        return ms;
    }
}
