import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = Arrays.toString(chars);
            if (map.containsKey(sortedStr)) {
                map.get(sortedStr).add(str);
            } else {
                map.put(sortedStr, new ArrayList<>(Arrays.asList(str)));
            }
        }
        return new ArrayList<>(map.values());
    }
}