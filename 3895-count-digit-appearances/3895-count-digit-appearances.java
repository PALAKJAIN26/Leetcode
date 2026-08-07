class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int totalCount = 0;
        
        for (int num : nums) {
            int temp = num;
            while (temp > 0) {
                if (temp % 10 == digit) {
                    totalCount++;
                }
                temp /= 10;
            }
        }
        
        return totalCount;
    }
}