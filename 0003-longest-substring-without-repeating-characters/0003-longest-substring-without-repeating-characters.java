class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int left=0;
        int MaxLength =0;
        
        for(int right=0; right <s.length();right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            MaxLength = Math.max(MaxLength,right-left+1);
        }
        return MaxLength;
    }
}