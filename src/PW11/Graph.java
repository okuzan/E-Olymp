package PW11;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;


@SuppressWarnings("Duplicates")
public class Graph {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= n ; i++) {
            g.add(new ArrayList<>());
        }
        String line;

        int i = 1;
        for (int j = 1; j <= n; j++) {
            line = sc.nextLine();
            int[] edges;

            if (!line.equals("")) {
                edges = Stream.of(line.split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int edge : edges)
                    g.get(edge).add(i);
            }
            i++;
        }

        System.out.println(n);

        for (int j = 1; j <= n; j++) {
            if (g.get(j) != null) {
                printAL(g.get(j));
            } else {
                System.out.println();
            }
        }
    }

    static void gPrint(ArrayList<ArrayList<Integer>> g){
        for (ArrayList<Integer> integers : g) {
            printAL(integers);
        }
    }
    static void printAL(ArrayList<Integer> arrayList) {
//        ArrayList<Integer> al = new ArrayList<>(arrayList);
        for (Integer integer : arrayList) {
            System.out.print(integer + " ");
        }
        System.out.print("\n");
    }
}
