import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>(List.of(banned));
        Map<String, Integer> map = new HashMap<>();
        String[] s = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");

        for (String w : s) {
            System.out.println("w = " + w);
            if (set.contains(w)) {
                continue;
            }
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}