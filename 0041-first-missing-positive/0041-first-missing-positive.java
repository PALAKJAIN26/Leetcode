class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean contains1 = false;

        // Step 1: Check for 1 and clean up invalid numbers
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                contains1 = true;
            } else if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        if (!contains1) return 1;

        // Step 2: Use sign as a presence marker
        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            int index = val - 1;

            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        // Step 3: Find the first positive value index
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }
}