class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] modCounts = new int[k];
        // Base case: a prefix sum divisible by k from index 0
        modCounts[0] = 1;

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;
            
            // Normalize remainder to handle negative values in Java
            int remainder = (prefixSum % k + k) % k;
            
            // If the same remainder has been seen before, those previous prefixes
            // form subarrays ending at the current index whose sums are divisible by k
            count += modCounts[remainder];
            
            // Record this remainder for future subarrays
            modCounts[remainder]++;
        }

        return count;
    }
}