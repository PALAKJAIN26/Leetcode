class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        int n = s.length();
        char[] sArr = s.toCharArray();
        char[] gArr = goal.toCharArray();

        for (int start = 0; start < n; start++) {
            // Only test rotations where the first character matches
            if (sArr[start] != gArr[0]) {
                continue;
            }

            int i = start; // Pointer in s
            int j = 0;     // Pointer in goal

            while (j < n && sArr[i] == gArr[j]) {
                i = (i + 1) % n;
                j++;
            }

            if (j == n) {
                return true;
            }
        }

        return false;
    }
}