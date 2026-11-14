class Solution {
    public int firstUniqChar(String s) {
        int len = s.length();
        int []count = new int[26];

        for(int i= 0; i <len; i++) {
            count[s.charAt(i) -'a']++;
        }
        for(int j =0; j<len; j++) {
            if(count[s.charAt(j)- 'a'] == 1){
                return j;
            }
        }
        return -1;
    }
}