class Solution {
    public boolean isSubsequence(String s, String t) {

        boolean result = false;
        int sIndex = 0;
        int tindex = 0;
        while (sIndex < s.length() && tindex < t.length()) {
            char c = s.charAt(sIndex);
            while (tindex < t.length()) {
                if (c == t.charAt(tindex++)) {
                    sIndex++;
                    break;
                }
            }
        }
        return sIndex == s.length();

    }
}