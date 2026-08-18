import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> windowCount = new HashMap<>();

        // Slide window of size k across the array
        for (int i = 0; i <= n - k; i++) {
            Set<Integer> uniqueInWindow = new HashSet<>();
            for (int j = i; j < i + k; j++) {
                uniqueInWindow.add(nums[j]);
            }

            for (int num : uniqueInWindow) {
                windowCount.put(num, windowCount.getOrDefault(num, 0) + 1);
            }
        }

        // Find the largest value present in exactly 1 window
        int maxVal = -1;
        for (Map.Entry<Integer, Integer> entry : windowCount.entrySet()) {
            if (entry.getValue() == 1) {
                maxVal = Math.max(maxVal, entry.getKey());
            }
        }

        return maxVal;
    }
}