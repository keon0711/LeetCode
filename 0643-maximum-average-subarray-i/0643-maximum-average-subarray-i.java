class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int result = 0;
        int average = 0;
        for (int i = 0; i < k; i++) {
            average += nums[i];
            result = average;
        }
        int left = 0, right = k;
        while (right < nums.length) {
            average += nums[right++];
            average -= nums[left++];
            result = Math.max(result, average);
        }
        return (double) result / k;
    }
}