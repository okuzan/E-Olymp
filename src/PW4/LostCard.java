package PW4;

import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class LostCard {
    private static void answer() {
        int[] data;
        int ans = 0;
        boolean exists;
        Scanner scan = new Scanner(System.in);
        data = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        scan.close();

        int size = data[0];
        for (int i = 1; i < size; i++) {
            exists = false;
            for (int k = 1; k < data.length; k++) {
                if (i == data[k]) {
                    exists = true;
                    break;
                } else if (i == size) {
                    ans = i;
                }
            }
            if (!exists) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        answer();
    }
}
