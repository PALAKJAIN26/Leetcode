class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int p = nums1.length;
        int q = nums2.length;

        int ans = 0;
        int lo = 1;
        int hi = Math.min(p, q);
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (f(nums1, nums2, mid)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    static long m = 1000000007;
    static long base = 1331;

    public static boolean f(int[] nums1, int[] nums2, int mid) {
        if (mid == 0) {
            return true;
        }
        int p = nums1.length;
        int q = nums2.length;
        long pow = 1;
        for (int i = 0; i < mid - 1; i++) {
            pow = (pow * base) % m;
        }
        
        long Hash1 = 0;
        for (int i = 0; i < mid; i++) {
            Hash1 = (Hash1 * base + nums1[i]) % m;
        }
        
        HashSet<Long> H1 = new HashSet<>();
        H1.add(Hash1);
        for (int i = mid; i < p; i++) {
            Hash1 = (((((Hash1 - ((nums1[i - mid] * pow) % m) + m) % m) * base) % m) + nums1[i]) % m;
            H1.add(Hash1);
        }

        long Hash2 = 0;
        for (int i = 0; i < mid; i++) {
            Hash2 = (Hash2 * base + nums2[i]) % m;
        }

        if (H1.contains(Hash2))
            return true;

        for (int j = mid; j < q; j++) {
            Hash2 = (((((Hash2 - ((nums2[j - mid] * pow) % m) + m) % m) * base) % m) + nums2[j]) % m;
            if (H1.contains(Hash2))
                return true;
        }
        return false;
    }
}