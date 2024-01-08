import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return new ArrayList<>();
        }
        Map<Character, char[]> keyMap = new HashMap<>();
        keyMap.put('2', new char[]{'a', 'b', 'c'});
        keyMap.put('3', new char[]{'d', 'e', 'f'});
        keyMap.put('4', new char[]{'g', 'h', 'i'});
        keyMap.put('5', new char[]{'j', 'k', 'l'});
        keyMap.put('6', new char[]{'m', 'n', 'o'});
        keyMap.put('7', new char[]{'p', 'q', 'r', 's'});
        keyMap.put('8', new char[]{'t', 'u', 'v'});
        keyMap.put('9', new char[]{'w', 'x', 'y', 'z'});
        
        List<String> result = new ArrayList<>();
        dfs(0, "", digits, keyMap, result);
        return result;
    }

    public void dfs(int index, String path, String digits, Map<Character, char[]> keyMap, List<String> result) {
        if (index == digits.length()) {
            result.add(path);
            return;
        }

        for (char c : keyMap.get(digits.charAt(index))) {
            dfs(index + 1, path + c, digits, keyMap, result);
        }
    }
}