import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        Collection<Integer> values = map.values();
        return values.size() == new HashSet<>(map.values()).size();
    }
}