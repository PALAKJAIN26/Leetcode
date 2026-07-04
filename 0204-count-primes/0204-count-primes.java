class Solution {
    public int countPrimes(int n) {
        // There are no primes less than 2
        if (n <= 2) {
            return 0;
        }
        
        int count = 1; 
        boolean[] isComposite = new boolean[n];
        
        for (int i = 3; i < n; i += 2) {
            if (!isComposite[i]) {
                count++;
                
                // Cross out multiples starting from i^2.
                if ((long) i * i < n) {
                   
                    for (int j = i * i; j < n; j += 2 * i) {
                        isComposite[j] = true;
                    }
                }
            }
        }
        
        return count;
    }
}