class Solution {

    public int pivotIndex(int[] nums) {
        int leftSum = 0, rightSum = 0;
        for (int i = 1; i < nums.length; i++) {
            rightSum += nums[i];
        }

        if (rightSum == leftSum) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            leftSum += nums[i - 1];
            rightSum -= nums[i];
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }
}