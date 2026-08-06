class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            answer[i] = leftSum;
            leftSum += nums[i];
        }
        int rightSum = 0;
        for (int i = n - 1; i >= 0; i--) {
            int diff = answer[i] - rightSum;
            
            if (diff < 0) {
                diff = -diff;
            }
            
            answer[i] = diff;
            rightSum += nums[i];
        }

        return answer;
    }
}