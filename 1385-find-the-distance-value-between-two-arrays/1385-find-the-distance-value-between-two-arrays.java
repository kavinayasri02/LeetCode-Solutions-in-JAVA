import java.util.Arrays;
public class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int dv = 0;
        Arrays.sort(arr2);
        for (int x : arr1) {
            // Find insertion point for the lower boundary (x - d)
            int index = Arrays.binarySearch(arr2, x - d);
            if (index < 0) {
                index = -index - 1;
            }
            if (index < arr2.length && arr2[index] <= x + d) {
                continue;
            }
            dv++;
        }
        
        return dv;
    }
}
