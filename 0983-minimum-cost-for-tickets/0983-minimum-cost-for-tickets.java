class Solution {
    
    public int mincostTickets(int[] days, int[] costs) {

        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];
        boolean[] travelDays = new boolean[lastDay + 1];

        for (int day : days) {
            travelDays[day] = true;
        }

        for (int day = 1; day <= lastDay; day++) {

            if (!travelDays[day]) {
                dp[day] = dp[day - 1];
                continue;
            }

            calcMinimumCost(costs, dp, day);
        }

        System.out.println(Arrays.toString(dp));
        return dp[lastDay];
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