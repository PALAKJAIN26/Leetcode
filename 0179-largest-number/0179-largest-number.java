class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] s = new String[n];

        for(int i =0; i<n; i++){
            s[i]= String.valueOf(nums[i]);
        }
        Arrays.sort(s,(s1,s2)->(s2+s1).compareTo(s1+s2));
        if(s[0].equals("0")){
            return"0";
        }

        StringBuilder sb = new StringBuilder("");

        for(int i = 0; i<n ; i++) {
            sb.append(s[i]);
        }
        return sb.toString();
    }
}