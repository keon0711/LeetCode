import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean check(String subString) {
        Set<Character> set = new HashSet<>();
        for (char c : subString.toCharArray()) {
            set.add(c);
        }
        if (subString.length() == set.size()) {
            return true;
        }
        return false;
    }

    public int lengthOfLongestSubstring(String s) {
        int window = 1;
        for (int i = 0; i < s.length(); i++) {
            while (i + window <= s.length()) {
                String substring = s.substring(i, i + window);
                if (!check(substring)) {
                    break;
                }
                window++;
            }
        }
        return window - 1;
    }
}