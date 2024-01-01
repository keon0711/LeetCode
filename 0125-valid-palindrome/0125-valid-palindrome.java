class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (!Character.isLetterOrDigit(chars[start])) {
                start++;
            } else if (!Character.isLetterOrDigit(chars[end])) {
                end--;
            } else {
                if (Character.toLowerCase(chars[start]) != Character.toLowerCase(chars[end])) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }
}