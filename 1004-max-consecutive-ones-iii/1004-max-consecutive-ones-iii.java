class Solution {
    public int longestOnes(int[] nums, int k) {
        int flipCount = k;

        int max = 0;
        int consequentCount = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] == 1) {
                consequentCount++;
                right++;
            } else if (nums[right] == 0 && flipCount > 0) {
                consequentCount++;
                right++;
                flipCount--;
            } else {
                if (nums[left] == 0) {
                    flipCount++;
                }
                consequentCount--;
                left++;
            }
            max = Math.max(max, consequentCount);
        }

        return max;
    }
}