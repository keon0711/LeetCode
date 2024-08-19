class Solution {
    
    public int mincostTickets(int[] days, int[] costs) {

        int[] dp = new int[days[days.length - 1] + 1];

        for (int day = 1; day <= days[days.length - 1]; day++) {
            if (!isDayInDays(days, day)){
                dp[day] = dp[day - 1];
                continue;
            }

            calcMinimumCost(costs, dp, day);
        }

        System.out.println(Arrays.toString(dp));
        return dp[days[days.length - 1]];
    }

    private static void calcMinimumCost(int[] costs, int[] dp, int day) {
        int cost1 = dp[day - 1] + costs[0];
        int cost2 = dp[Math.max(day - 7, 0)] + costs[1];
        int cost3 = dp[Math.max(day - 30, 0)] + costs[2];

        dp[day] = Math.min(cost1, Math.min(cost2, cost3));
    }

    private static boolean isDayInDays(int[] days, int day) {
        boolean flag = false;
        for (int i : days) {
            if (i == day) {
                flag = true;
                break;
            }
        }
        return flag;
    }

}