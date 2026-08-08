class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;

        while (left < right) {
            int currentHeight = Math.min(height[left], height[right]);
            int width = right - left;
            int area = currentHeight * width;

            maxWater = Math.max(maxWater, area);

            // Move the pointer that points to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}