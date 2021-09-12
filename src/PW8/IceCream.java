package PW8;

import java.util.Scanner;

public class IceCream {

    static int nShops, nSellers;
    static int[] coords;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        nShops = scan.nextInt();
        nSellers = scan.nextInt();
        coords = new int[nShops];
        for (int i = 0; i < nShops; i++) {
            coords[i] = scan.nextInt();
        }
        scan.close();

        int first = 0, last = 1000000000;
        while (first <= last) {
            int mid = (first + last) / 2;
            if (check(mid) == 1) first = mid + 1;
            else last = mid - 1;
        }
        System.out.println(first - 1);
    }

    static int check(int value) {
        int i, stall = 1, len = 0;
        for (i = 1; i < nShops; i++) {
            len += coords[i] - coords[i - 1];
            if (len >= value) {
                len = 0;
                stall++;
            }
        }

        int ans = (stall >= nSellers) ? 1 : 0;
        return ans;
    }


}
