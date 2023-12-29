class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] complement = new int[nums.length];
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            complement[i] = target - nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (complement[i] == nums[j]) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return new int[]{};
    }
}
