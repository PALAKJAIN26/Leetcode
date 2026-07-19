/*class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        int n = nums.length;
        
        Arrays.sort(nums);

        int[] integer = new int[n];
        int x;
        int y;
        Map<Integer , Integer> = new HashMap<> ();

        for(int i =0; i<n; i++){
            int freq=0;
            if(x<y){
                freq[x] != freq[y];
            }
        }

        
    }
}*/
class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        int[] freq = new int[101];
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }
        
        for (int x = 1; x <= 100; x++) {
            if (freq[x] > 0) { 
                for (int y = x + 1; y <= 100; y++) {

                    if (freq[y] > 0 && freq[x] != freq[y]) {
                        return new int[]{x, y};
                    }
                }
            }
        }
        
        return new int[]{-1, -1};
    }
}