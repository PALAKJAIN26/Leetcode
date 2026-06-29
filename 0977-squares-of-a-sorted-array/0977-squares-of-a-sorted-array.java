class Solution {
    public int[] sortedSquares(int[] nums) {
        int j=0;

        for(int i:nums){
            nums[j++]=i*i;
            // return nums;
        }
        Arrays.sort(nums);
        return nums;
    }
}