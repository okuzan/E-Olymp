package PW9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PhoneList {

    static class Item {
        int leaf;
        int[] next = new int[10];

        Item() {
            for (int i = 0; i < 10; i++) next[i] = -1;
            leaf = 0;
        }

        @Override
        public String toString() {
            return "Leaf: " + leaf + " | " + Arrays.toString(next);
        }
    }

    static boolean answer;
    static ArrayList<Item> trie = new ArrayList<>();

    private static void insert(char[] number) {
        int i, v = 0;
//        Item temp = new Item();
        if (answer) return;
//        System.out.println("!");
//        System.out.println(trie.toString());
        for (i = 0; i < number.length; i++) {
            if (trie.get(v).leaf == 1) {
//                System.out.println(answer);
                answer = true;
                return;
            }
            char c = (char) (number[i] - '0');
//            System.out.println("C: " + (int) c);
            if (trie.get(v).next[c] == -1) {
                trie.get(v).next[c] = trie.size();
//                System.out.println("TEMP: " + new Item().toString());
                trie.add(new Item());
            }

            v = trie.get(v).next[c];
//            System.out.println("v " + v + ", c" + (int) c);
//            System.out.println("_V_ " + v);
        }

        for (i = 0; i < 10; i++) {
            if (trie.get(v).next[i] != -1) {
//                System.out.println("STRIIIKE!0");
                answer = true;
            }
        }
        if (trie.get(v).leaf == 1) {
//            System.out.println("STRIIIKE!1");
            answer = true;
        }
        trie.get(v).leaf = 1;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int nTests = scan.nextInt();
        for (int i = 0; i < nTests; i++) {
            trie.clear();
            trie.add(new Item());

            int qNums = scan.nextInt();
            answer = false;

            for (int j = 0; j < qNums; j++) {
                String str = "" + scan.nextInt();
//                System.out.println(str);
                char[] number = str.toCharArray();
//                System.out.println(Arrays.toString(number));
                insert(number);
            }
            System.out.println(answer ? "NO" : "YES");
        }
    }
}
