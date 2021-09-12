package PW2;

import java.util.Scanner;

public class RabbitUFO {

    static String simulation(int m, int k) {
        int rab = 1;

        for (int i = 0; i < m; i++) {
            if (rab > k) rab -= k;
            rab *= 2;
        }

        return "" + rab;
    }

    public static void main(String[] args) {
        int i, j;
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            i = scan.nextInt();
            j = scan.nextInt();
            System.out.println(simulation(i, j));
            break;
        }
    }

}
