/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                // mid is bad; the first bad version is at or before mid
                right = mid;
            } else {
                // mid is good; the first bad version must be after mid
                left = mid + 1;
            }
        }

        // When left == right, we've converged on the first bad version
        return left;
    }
}