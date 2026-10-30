class Solution {
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> seen = new HashSet<>();

        for(int i =0; i<nums.length; i++){
            int Nums = nums[i];

            if(seen.contains(Nums)){
                return true;
            }
            seen.add(Nums);
        }
        return false;
    }
}