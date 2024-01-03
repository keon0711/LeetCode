
class Solution {
    int left, maxLen;

    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            check(s, i, i + 1);
            check(s, i, i + 2);
        }

        return s.substring(left, left + maxLen);
    }

    public void check(String s, int j, int k) {
        char[] chars = s.toCharArray();
        while (j >= 0 && k < s.length() && chars[j] == chars[k]) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            left = j + 1;
            maxLen = k - j - 1;
        }
    }
}