package PW8;

import java.util.Scanner;

import static java.lang.Math.max;

@SuppressWarnings("Duplicates")
public class Knapsack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int nMissions = scan.nextInt();
        int nPoints = scan.nextInt();

        int val[] = new int[nMissions];
        int wt[] = new int[nMissions];

        for (int i = 0; i < nMissions; i++) {
            val[i] = scan.nextInt();
            wt[i] = scan.nextInt();
        }
        System.out.println(knapSack(nPoints, wt, val, val.length));
    }

    static int knapSack(int W, int wt[], int val[], int n) {
        int i, w;
        int K[][] = new int[n + 1][W + 1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w] = max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        return K[n][W];
    }

    static class MyUnit implements Comparable<Wormix.MyUnit> {
        int points, time;
        double cpa;

        MyUnit(int p, int t) {
            points = p;
            time = t;
            cpa = (double) p / t;
        }

        @Override
        public String toString() {
            return "{p = " + points + ", t = " + time + ", c = " + cpa + "}";
        }

        @Override
        public int compareTo(Wormix.MyUnit o) {
            double cpa = (o.cpa - this.cpa);
            int time = this.time - o.time;

            if (cpa > 0) return 1;
            if (cpa < 0) return -1;
            return -time;
        }
    }
}
