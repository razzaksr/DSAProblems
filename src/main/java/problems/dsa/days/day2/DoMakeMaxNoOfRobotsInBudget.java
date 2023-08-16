package problems.dsa.days.day2;

public class DoMakeMaxNoOfRobotsInBudget {
    public static int maxConsecutiveRobots(int[] chargeTimes, int[] runningCosts, int budget) {
        int n = chargeTimes.length;
        int maxConsecutive = 0;
        int totalCost = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            totalCost += chargeTimes[windowEnd] + (runningCosts[windowEnd] * (windowEnd - windowStart + 1));

            while (totalCost > budget) {
                totalCost -= chargeTimes[windowStart] + (runningCosts[windowStart] * (windowEnd - windowStart + 1));
                windowStart++;
            }

            maxConsecutive = Math.max(maxConsecutive, windowEnd - windowStart + 1);
        }

        return maxConsecutive;
    }

    public static void main(String[] args) {
        int[] chargeTimes1 = {3, 6, 1, 3, 4};
        int[] runningCosts1 = {2, 1, 3, 4, 5};
        int budget1 = 25;
        System.out.println(maxConsecutiveRobots(chargeTimes1, runningCosts1, budget1));  // Output: 3

        int[] chargeTimes2 = {11, 12, 19};
        int[] runningCosts2 = {10, 8, 7};
        int budget2 = 19;
        System.out.println(maxConsecutiveRobots(chargeTimes2, runningCosts2, budget2));  // Output: 0
    }
}
