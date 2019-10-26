import java.util.Arrays;
import java.util.Scanner;

public class H {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (!str.matches("[0-9]+ [0-9]+")) {
            System.exit(-1);
        }
        String[] read = str.split(" ");
        int number = Integer.valueOf(read[0]);
        int maxWeight = Integer.valueOf(read[1]);

        int[] weights = new int[number];
        int[] values = new int[number];

        int index = 0;
        int max = 0;

        while (sc.hasNextLine() && index < number) {
            str = sc.nextLine();
            if (!str.matches("[0-9]+ [0-9]+")) {
                System.exit(-1);
            }
            read = str.split(" ");
            int weight = Integer.valueOf(read[0]);
            int val = Integer.valueOf(read[1]);
            max = Math.max(max, weight);
            weights[index] = weight;
            values[index] = val;
            index++;
        }

        for(int i = 0; i < weights.length; i++) {
            int[] curr_w = new int[weights.length - 1];
            int[] curr_v = new int[weights.length - 1];
            System.arraycopy(weights, 0, curr_w, 0, i);
            System.arraycopy(weights, i + 1, curr_w, i, weights.length - i - 1);
            System.arraycopy(values, 0, curr_v, 0, i);
            System.arraycopy(values, i + 1, curr_v, i, values.length - i - 1);
            System.out.println(Arrays.toString(curr_w));
            System.out.println(Arrays.toString(curr_v));
            System.out.println(knapsack(curr_w, curr_v, maxWeight));
        }

    }

    public static int knapsack(int[] weights, int[] values, int max) {

        int[][] m = new int[weights.length + 1][max + 1]; // i neighbors, total max
        for (int i = 1; i <= m.length - 1; i++) { // row
            for (int j = 1; j <= m[0].length - 1; j++){ //column -> weights
                if (weights[i - 1] > j) {
                    m[i][j] = m[i-1][j];
                } else {
                    m[i][j] = Math.max(m[i-1][j], values[i-1] + m[i-1][j - weights[i -1]]);
                }
            }
        }
        return m[m.length - 1][m[0].length - 1];
    }

}
