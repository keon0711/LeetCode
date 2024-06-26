class Solution {
    public void moveZeroes(int[] nums) {

        Queue<Integer> zeroIndexes = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroIndexes.add(i);
            } else if (!zeroIndexes.isEmpty()) {
                nums[zeroIndexes.poll()] = nums[i];
                nums[i] = 0;
                zeroIndexes.add(i);
            }
        }
    }
}