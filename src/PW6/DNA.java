package PW6;

import java.util.Arrays;
import java.util.Scanner;

public class DNA {

    static class MyPair implements Comparable<MyPair> {

        private final Integer key;
        private final String value;

        public MyPair(Integer aKey, String aValue) {
            key = aKey;
            value = aValue;
        }

        @Override
        public String toString() {
            return value;
        }

        @Override
        public int compareTo(MyPair o) {
            if (key > o.key)
                return 1;
            if (key < o.key)
                return -1;
            return 0;
        }
    }

    private static int degree(String s) {

        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            char pivot = s.charAt(i);
            for (int j = 0; j < i; j++) if (s.charAt(j) > pivot) counter++;

            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) < pivot) {
                    counter++;
                }
            }

        }
        return counter;
    }

    private static void sort(String[] data) {
        MyPair[] pairs = new MyPair[data.length];
        int i = 0;
        for (String s : data) {
            MyPair pair = new MyPair(degree(s), s);
            pairs[i] = pair;
            i++;
        }

        Arrays.sort(pairs);
        for (int j = 0; j < pairs.length; j++) {
            System.out.println(pairs[j].toString());
        }
        System.out.println();
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int nTests = scanner.nextInt();

        scanner.nextLine();
        for (int i = 0; i < nTests; i++) {

            scanner.nextLine();

            int size = scanner.nextInt();
            int quantity = scanner.nextInt();

            String[] data = new String[quantity];

            scanner.nextLine();
            for (int j = 0; j < quantity; j++) {
                String str = scanner.nextLine();
                data[j] = str;
            }

            sort(data);
        }
    }
}