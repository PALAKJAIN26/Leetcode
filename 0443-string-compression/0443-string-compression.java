class Solution {
    public int compress(char[] chars) {
        int slow = 0; // Write pointer (tracks position for the compressed result)
        int fast = 0; // Read pointer (scans through the array)

        while (fast < chars.length) {
            char currentChar = chars[fast];
            int count = 0;

            // Count consecutive occurrences of currentChar
            while (fast < chars.length && chars[fast] == currentChar) {
                fast++;
                count++;
            }

            // Write the character at the slow pointer
            chars[slow++] = currentChar;

            // If it appeared more than once, write each digit of count
            if (count > 1) {
                for (char digit : Integer.toString(count).toCharArray()) {
                    chars[slow++] = digit;
                }
            }
        }

        return slow;
    }
}