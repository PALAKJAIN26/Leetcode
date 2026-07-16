class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        
        int Max = 0;
        for (int i = 0; i < n; i++) {
            Max = Math.max(Max, nums[i]);
            prefix[i] = gcd(nums[i], Max);
        }
        Arrays.sort(prefix);
        
        long totalSum = 0;
        int left = 0;
        int right = n - 1;
        
        while (left < right) {
            totalSum += gcd(prefix[left], prefix[right]);
            left++;
            right--;
        }
        
        return totalSum;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}