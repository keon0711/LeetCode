class Solution {
    public int maxVowels(String s, int k) {
        int numOfVowels = 0;
        for (int i = 0; i < k; i++) {
            char c = s.charAt(i);
            if (isVowel(c)) {
                numOfVowels++;
            }
        }
        int maxVowels = numOfVowels;
        int left = 0, right = k;
        while (right < s.length()) {
            if (isVowel(s.charAt(right++))) {
                numOfVowels++;
            }
            if (isVowel(s.charAt(left++))) {
                numOfVowels--;
            }
            maxVowels = Math.max(maxVowels, numOfVowels);
        }

        return maxVowels;
    }

    private boolean isVowel(char c) {
        String vowels = "aeiouAEIOU";

        return vowels.indexOf(c) != -1;
    }
}