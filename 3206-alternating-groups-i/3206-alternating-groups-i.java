class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int n=colors.length;
        int count=0;
        for(int i=0;i<n;i++){
            int l=(i - 1+n) % n;int r=(i + 1) % n;
            if(colors[l]!=colors[i] && colors[r]!=colors[i]){
                count++;
            }
            // l=(colors[l] + 1) % n;r=(colors[r] + 1) % n;
            // l++;r++;
        }
        return count;
    }
}