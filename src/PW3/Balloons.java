package PW3;

import java.util.Scanner;

public class Balloons {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int max = 0;
        int[] count = new int[9];

        for (int i = 0; i < n; i++) {
            int temp = scan.nextInt();
            count[temp - 1] += 1;
        }
        for (int i = 0; i < 9; i++) {
            int value = count[i];
            if (value > max) max = value;
        }

        System.out.println(n - max);
    }
}



