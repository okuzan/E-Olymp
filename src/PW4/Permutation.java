package PW4;

import java.util.Scanner;

public class Permutation {

    public static void main(String[] args) {

        int ans;
        Scanner scan = new Scanner(System.in);

        int temp = 0;
        int size = scan.nextInt();

        temp += (1 + size) * (size / 2);
        if (size % 2 == 1) temp += (size + 1) / 2;

        for (int i = 1; i < size; i++) temp -= scan.nextInt();
        ans = temp;
        scan.close();

        System.out.println(ans);
    }
}
