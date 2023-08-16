package problems.dsa.days.day1;

import java.util.Arrays;

public class WiresGreedy {
    public static int minimumCostToAssembleWires(int[] wires) {
        int n = wires.length;
        Arrays.sort(wires); // Sort the wires in ascending order
        System.out.println(Arrays.toString(wires));
        int totalCost = 0;

        while (n > 1) {
            int cost = wires[0] + wires[1]; // Merge the two shortest wires
            totalCost += cost;
            // Remove the two shortest wires and insert the merged wire
            wires[1] = cost;
            System.out.println(Arrays.toString(wires));
            for (int i = 2; i < n; i++) {
                wires[i - 1] = wires[i];
                System.out.println(wires[i-1]);
            }
            System.out.println(Arrays.toString(wires)+" "+totalCost);
            n--; // Decrease the number of wires
        }
        return totalCost;
    }
    public static void main(String[] args) {
        int[] wires = {7, 6, 8, 6, 1, 1};
        int minCost = minimumCostToAssembleWires(wires);
        System.out.println("Minimum cost to assemble all gold wires: " + minCost);
    }

}
