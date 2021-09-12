package PW2;

import java.util.Scanner;

public class Gardener {

    static String simulation(int n) {
        int leaves = 1 + (2 * n + 2) * (n / 2);
        if (n % 2 == 1) leaves += n + 1;
        return "" + leaves;
    }

    public static void main(String[] args) {
        int i;
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            i = scan.nextInt();
            System.out.println(simulation(i));
            break;
        }
    }
}
