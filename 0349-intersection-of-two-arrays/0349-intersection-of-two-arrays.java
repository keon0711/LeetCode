import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        for (int i : nums1) {
            for (int j : nums2) {
                if (i == j) {
                    set.add(i);
                }
            }
        }
        return set.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
    
}