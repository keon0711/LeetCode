class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();

        if (strs.length == 1) {
            return strs[0];
        }

        int i = 0;
        while (true) {
            for (int j = 0; j < strs.length - 1; j++) {
                if (i == strs[j].length() || i == strs[j + 1].length()) {
                    return sb.toString();
                }
                if (strs[j].charAt(i) != (strs[j + 1].charAt(i))) {
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(i));
            i++;
        }
    }
}