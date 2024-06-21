class Solution {

    private Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
    
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> vowelsInS = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (vowels.contains(c)) {
                vowelsInS.addFirst(c);
            }
        }

        for (char c : s.toCharArray()) {
            if (vowels.contains(c)) {
                sb.append(vowelsInS.removeFirst());
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}