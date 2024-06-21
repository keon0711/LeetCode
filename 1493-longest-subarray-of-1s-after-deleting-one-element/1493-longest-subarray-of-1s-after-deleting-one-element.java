class Solution {
    public int longestSubarray(int[] nums) {
        if (Arrays.stream(nums)
            .allMatch(num -> num == 1)) {
            return nums.length - 1;
        }
        int result = 0;

        int lengthOfSubArray = 0;
        boolean canRemove = true;
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] == 1) {
                lengthOfSubArray++;
                right++;
            } else if (canRemove) {
                canRemove = false;
                right++;
            } else {
                if (nums[left] == 0) {
                    canRemove = true;
                } else {
                    lengthOfSubArray--;
                }
                left++;
            }
            result = Math.max(result, lengthOfSubArray);
        }
        return result;
    }
}