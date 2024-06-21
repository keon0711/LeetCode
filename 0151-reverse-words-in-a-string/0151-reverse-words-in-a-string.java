import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public String reverseWords(String s) {
        String[] split = s.trim().split("\\s+");

        List<String> list = Arrays.asList(split);
        Collections.reverse(list);
        return String.join(" ", list);
    }
}