import java.util.Arrays;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            left[i] = nums[i];
            right[n - 1 - i] = nums[n - 1 - i];
            if (i > 0) {
                left[i] *= left[i - 1];
                right[n - 1 - i] *= right[n - i];
            }
        }
        for (int i = 0; i < n; i++) {
            answer[i] = 1;
            if (i > 0)
                answer[i] *= left[i - 1];
            if (i < n - 1)
                answer[i] *= right[i + 1];
        }
        return answer;
    }
}