class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        
        // Total number of odd candidates strictly greater than 1 and less than n
        int oddCandidates = (n - 2) / 2;
        
        // Each int has 32 bits. We divide the number of candidates by 32 
        // (using >> 5) and add 1 to ensure we have enough space.
        int[] isComposite = new int[(oddCandidates >> 5) + 1];
        
        int count = oddCandidates;
        
        for (int i = 0; i < oddCandidates; i++) {
            int p = 2 * i + 3; 
            
            if ((long) p * p >= n) {
                break;
            }
            
            // Check if the i-th bit is 0 (meaning it's prime)
            // i >> 5 finds the int bucket. (1 << (i & 31)) creates a mask for the exact bit.
            if ((isComposite[i >> 5] & (1 << (i & 31))) == 0) {
                
                int firstMultipleIndex = (p * p - 3) / 2;
                
                for (int j = firstMultipleIndex; j < oddCandidates; j += p) {
                    // If the j-th bit is not already set to 1
                    if ((isComposite[j >> 5] & (1 << (j & 31))) == 0) {
                        // Set the j-th bit to 1 using bitwise OR
                        isComposite[j >> 5] |= (1 << (j & 31));
                        count--; 
                    }
                }
            }
        }
        
        return count + 1;
    }
}