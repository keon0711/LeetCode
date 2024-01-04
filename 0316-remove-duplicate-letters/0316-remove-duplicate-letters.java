import java.util.Set;
import java.util.TreeSet;

class Solution {

    public Set<Character> sortedSet(String s) {
        Set<Character> sortedSet = new TreeSet<>();
        for (char c : s.toCharArray()) {
            sortedSet.add(c);
        }

        return sortedSet;
    }

    public String removeDuplicateLetters(String s) {
        for (char c : sortedSet(s)) {
            String suffix = s.substring(s.indexOf(c));
            if (sortedSet(s).equals(sortedSet(suffix))) {
                return c + removeDuplicateLetters(suffix.replaceAll(String.valueOf(c), ""));
            }
        }
        return "";
    }
}