import java.util.HashSet;
import java.util.Set;

class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        // Converted enhanced for-loop to standard indexed for-loop
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                set.add(nums[i]);
            }
        }

        int target = 1;
        while (set.contains(target)) {
            target++;
        }

        return target;
    }
}