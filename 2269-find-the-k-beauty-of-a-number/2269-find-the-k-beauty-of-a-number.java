class Solution {
    public int divisorSubstrings(int num, int k) {
        String s = String.valueOf(num);
        int count = 0;
        
        // Slide a window of size k across the string representation of num
        for (int i = 0; i <= s.length() - k; i++) {
            // Extract the substring of length k
            String sub = s.substring(i, i + k);
            
            // Convert back to integer
            int val = Integer.parseInt(sub);
            
            // Avoid division by zero and check if it's a divisor of num
            if (val != 0 && num % val == 0) {
                count++;
            }
        }
        
        return count;
    }
}