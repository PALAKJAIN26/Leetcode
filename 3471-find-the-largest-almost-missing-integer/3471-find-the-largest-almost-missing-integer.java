class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        // Case 1: Entire array is a single window
        if (k == n) {
            int maxVal = -1;
            for (int x : nums) {
                maxVal = Math.max(maxVal, x);
            }
            return maxVal;
        }

        // Count occurrences of each number
        int[] freq = new int[51];
        for (int x : nums) {
            freq[x]++;
        }

        // Case 2: Subarrays of size 1
        if (k == 1) {
            for (int val = 50; val >= 0; val--) {
                if (freq[val] == 1) {
                    return val;
                }
            }
            return -1;
        }

        // Case 3: 1 < k < n
        int res = -1;
        if (freq[nums[0]] == 1) {
            res = Math.max(res, nums[0]);
        }
        if (freq[nums[n - 1]] == 1) {
            res = Math.max(res, nums[n - 1]);
        }

        return res;
    }
}