class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int maxLen = 0;

        // dp[j] stores the length of the longest common suffix of nums1[0..i-1] and nums2[0..j-1]
        int[] dp = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            // Iterate backwards to update dp array in-place without extra space
            for (int j = n; j >= 1; j--) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                    maxLen = Math.max(maxLen, dp[j]);
                } else {
                    dp[j] = 0;
                }
            }
        }

        return maxLen;
    }
}