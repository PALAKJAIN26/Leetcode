class Solution {
    public int countPrimes(int n) {
        // A prime number is greater than 1. 
        // If n is 0, 1, or 2, there are strictly 0 primes less than n.
        if (n <= 2) {
            return 0;
        }
        
        // boolean arrays default to false in Java. 
        // We track if a number is a composite (non-prime).
        boolean[] isComposite = new boolean[n];
        int count = 0;
        
        for (int i = 2; i < n; i++) {
            // If the number hasn't been crossed out, it's a prime
            if (!isComposite[i]) {
                count++;
                
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isComposite[j] = true;
                    }
                }
            }
        }
        
        return count;
    }
}