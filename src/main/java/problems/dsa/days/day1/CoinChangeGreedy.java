package problems.dsa.days.day1;

import java.util.Arrays;

public class CoinChangeGreedy {
    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int coinCount = 0;
        int index = coins.length - 1;

        while (amount > 0 && index >= 0) {
            if (coins[index] <= amount) {
                System.out.println(coins[index]);
                amount -= coins[index];
                coinCount++;
            } else {
                index--;
            }
        }

        return amount==0?coinCount:-1;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(coinChange(coins, 11));
        coins=new int[]{5,10};
        System.out.println(coinChange(coins, 50));
    }

}
