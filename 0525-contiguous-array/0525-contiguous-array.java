import java.util.Arrays;

class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        // Range of sum is [-n, n], requiring a size of 2 * n + 1
        int[] firstSeen = new int[2 * n + 1];
        
        // Use -2 to represent unvisited states (-1 represents the base index 0 at count 0)
        Arrays.fill(firstSeen, -2);
        
        // Base case: count 0 seen at virtual index -1
        firstSeen[n] = -1;
        
        int maxLength = 0;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            count += (nums[i] == 1) ? 1 : -1;
            
            int shiftedIndex = count + n;
            
            if (firstSeen[shiftedIndex] >= -1) {
                // If already seen, calculate subarray length
                maxLength = Math.max(maxLength, i - firstSeen[shiftedIndex]);
            } else {
                // Store first occurrence
                firstSeen[shiftedIndex] = i;
            }
        }
        
        return maxLength;
    }
}