import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> distances = new HashSet<>();
        
        // Add all 6 pairwise squared distances
        distances.add(distSquared(p1, p2));
        distances.add(distSquared(p1, p3));
        distances.add(distSquared(p1, p4));
        distances.add(distSquared(p2, p3));
        distances.add(distSquared(p2, p4));
        distances.add(distSquared(p3, p4));
        
        // A valid square must have exactly 2 unique squared distances (sides and diagonals),
        // and none of them can be 0 (which would mean duplicate points).
        return !distances.contains(0) && distances.size() == 2;
    }
    
    private int distSquared(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}