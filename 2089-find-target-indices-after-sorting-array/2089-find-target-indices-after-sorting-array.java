import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int lesser = 0;
        int same = 0;
        
        // Count elements strictly less than target and elements equal to target
        for (int x : nums) {
            if (x < target) {
                lesser++;
            } else if (x == target) {
                same++;
            }
        }
        
        // Build the result list with indices from lesser up to lesser + same - 1
        List<Integer> ans = new ArrayList<>();
        for (int i = lesser; i < lesser + same; i++) {
            ans.add(i);
        }
        
        return ans;
    }
}