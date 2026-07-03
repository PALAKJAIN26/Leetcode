class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n=nums.length;
        boolean[] seen=new boolean[2001];
        int uniq=0;
        for (int i=0;i<n;i++){
            if(!seen[nums[i]]){
                seen[nums[i]]=true;
                uniq++;
            }
        }
        int[] freq = new int[2001];
        int distinct = 0;
        int count = 0;
        int left = 0;

        for(int r=0;r<n;r++){
            if(freq[nums[r]]==0){
                distinct++;
            }
            freq[nums[r]]++;
            while(distinct==uniq){
                count+=(n-r);
                freq[nums[left]]--;
                if(freq[nums[left]]==0){
                    distinct--;
                }
                left++;
            }
        }

        return count;
        
    }
}