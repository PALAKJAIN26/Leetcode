class Solution {
    public int firstUniqueEven(int[] nums) {
        int[] freq = new int[101];
        
        // Step 1: Count frequencies
        for (int num : nums) {
            freq[num]++;
        }
        
        // Step 2: Find the first even element with frequency 1
        for (int num : nums) {
            if (num % 2 == 0 && freq[num] == 1) {
                return num;
            }
        }
        
        // Step 3: Return -1 if no such element exists
        return -1;
    }
}