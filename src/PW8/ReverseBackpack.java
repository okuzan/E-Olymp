package PW8;

import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class ReverseBackpack {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int nMissions = scan.nextInt();
        int nPoints = scan.nextInt();

        ArrayList items = new ArrayList<Item>();
        int total = 0;
        for (int i = 0; i < nMissions; i++) {

            int points = scan.nextInt();
            int value = scan.nextInt();

            Item item = new Item(points, value);
            items.add(item);
            total += points;
        }
//        System.out.println(items.toString());

        if (total < nPoints) {
            System.out.println(-1);
            return;
        }
//        System.out.println("Total: " + total);
        ArrayList toDelete = knapsack(total - nPoints, items);
//        System.out.println(toDelete.toString());
        int s = toDelete.size();


        for (int i = 0; i < s; i++) {
            items.remove(toDelete.get(0));
            toDelete.remove(0);
        }

        int answer = 0;
        for (int i = 0; i < items.size(); i++) {
            Item item = (Item) items.get(i);
            answer += item.value;
        }
        System.out.println(answer);
    }

    private static ArrayList<Item> knapsack(int capacity, ArrayList<Item> items) {
        int NB_ITEMS = items.size();
        // we use a matrix to store the max value at each n-th item
        int[][] matrix = new int[NB_ITEMS + 1][capacity + 1];

        // first line is initialized to 0
        for (int i = 0; i <= capacity; i++)
            matrix[0][i] = 0;

        // we iterate on items
        for (int i = 1; i <= NB_ITEMS; i++) {
            // we iterate on each capacity
            for (int j = 0; j <= capacity; j++) {
                if (items.get(i - 1).weight > j)
                    matrix[i][j] = matrix[i - 1][j];
                else
                    // we maximize value at this rank in the matrix
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j - items.get(i - 1).weight]
                            + items.get(i - 1).value);
            }
        }

        int res = matrix[NB_ITEMS][capacity];
        int w = capacity;
        ArrayList<Item> itemsSolution = new ArrayList<>();

        for (int i = NB_ITEMS; i > 0 && res > 0; i--) {
            if (res != matrix[i - 1][w]) {
                itemsSolution.add(items.get(i - 1));
                // we remove items value and weight
                res -= items.get(i - 1).value;
                w -= items.get(i - 1).weight;
            }
        }
        return itemsSolution;
    }

    public static class Item {
        int weight, value;

        @Override
        public String toString() {
            return "[weight=" + weight + ", value=" + value + "]";
        }

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

}