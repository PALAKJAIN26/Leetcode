import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;

        int limit = (int) Math.sqrt(n);
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);

        // Step 1: Find all primes up to sqrt(n) using a simple sieve
        for (int p = 2; p * p <= limit; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= limit; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        for (int p = 2; p <= limit; p++) {
            if (isPrime[p]) {
                primes.add(p);
            }
        }

        // Step 2: Segmented Sieve for the rest of the numbers
        int count = 0;
        int segmentSize = limit; 
        boolean[] segment = new boolean[segmentSize];

        for (int low = 2; low < n; low += segmentSize) {
            int high = Math.min(low + segmentSize - 1, n - 1);
            Arrays.fill(segment, true);

            // Mark composites in the current segment using base primes
            for (int prime : primes) {
                // Find the first multiple of 'prime' in the range [low, high]
                int startIdx = (low / prime) * prime;
                if (startIdx < low) {
                    startIdx += prime;
                }
                if (startIdx == prime) {
                    startIdx += prime; // Don't mark the prime itself
                }

                for (int j = startIdx; j <= high; j += prime) {
                    segment[j - low] = false;
                }
            }

            // Count primes in this segment
            for (int i = low; i <= high; i++) {
                if (segment[i - low]) {
                    count++;
                }
            }
        }

        return count;
    }
}