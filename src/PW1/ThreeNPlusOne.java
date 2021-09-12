package PW1;

import java.util.Scanner;

public class ThreeNPlusOne {

    static int cycleLength(int n) {
        int count = 1;

        while (n != 1) {
            if (n % 2 == 1) {
                n = 3 * n + 1;
            } else
                n = n / 2;
            count++;
        }
        return count;
    }

    static int choose(int i, int j) {
        int ans = 0;
        for (int k = Math.min(i, j); k <= Math.max(i, j); k++) {
            if (cycleLength(k) > ans) ans = cycleLength(k);
        }
        return ans;
    }

    public static void main(String[] args) {
        int i, j;
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            i = scan.nextInt();
            j = scan.nextInt();

            System.out.println(i + " " + j + " " + choose(i, j));
        }

    }
}
