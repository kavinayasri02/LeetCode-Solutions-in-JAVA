import java.util.ArrayList;
import java.util.List;
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();
        backtrack(nums, 0, currentSubset, result);
        return result;
    }
    private void backtrack(int[] nums, int start, List<Integer> currentSubset, List<List<Integer>> result) {
        result.add(new ArrayList<>(currentSubset));
        for (int i = start; i < nums.length; i++) {
            // Include the current element
            currentSubset.add(nums[i]);
            backtrack(nums, i + 1, currentSubset, result);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}
