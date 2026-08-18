class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int[] windowCount = new int[51];

        for (int i = 0; i <= n - k; i++) {
            boolean[] seenInWindow = new boolean[51];
            for (int j = i; j < i + k; j++) {
                seenInWindow[nums[j]] = true;
            }
            for (int val = 0; val <= 50; val++) {
                if (seenInWindow[val]) {
                    windowCount[val]++;
                }
            }
        }

        for (int val = 50; val >= 0; val--) {
            if (windowCount[val] == 1) {
                return val;
            }
        }

        return -1;
    }
}