class Solution {
    public int reverse(int x) {
        int answer = 0;

        while (x != 0) {
            int tmp = (answer * 10) + (x % 10);
            if ((tmp - (x % 10)) / 10 != answer) {
                return 0;
            }
            answer = tmp;
            x /= 10;
        }
        System.out.println("answer = " + answer);
        return answer;
    }
}