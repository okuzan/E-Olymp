package PW12;

import java.util.Scanner;

public class ReverseGraph {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                int a = sc.nextInt();
                if (i == k && a == 1) {
                    System.out.println("NO");
                    System.exit(0);
                }
                matrix[i][k] = a;
            }
        }

        int nn = matrix.length;

        for (int i = 0; i < nn; i++)
            for (int j = 0; j < nn; j++)
                if (matrix[i][j] != matrix[j][i]) {
                    System.out.println("NO");
                    System.exit(0);
                }

        System.out.println("YES");
    }
}
