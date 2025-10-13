//Minimum Cost for Traveling Tickets
import java.util.*;

public class MinimumCostForTickets {
    public static int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n + 1];
        dp[n] = 0; // after last day, cost is zero

        for (int i = n - 1; i >= 0; i--) {
            int cost1 = costs[0] + dp[i + 1];

            int j = i;
            while (j < n && days[j] < days[i] + 7) {
                j++;
            }
            int cost7 = costs[1] + dp[j];

            j = i;
            while (j < n && days[j] < days[i] + 30) {
                j++;
            }
            int cost30 = costs[2] + dp[j];

            dp[i] = Math.min(cost1, Math.min(cost7, cost30));
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        System.out.println("Minimum cost for traveling: " + mincostTickets(days, costs));
    }
}
