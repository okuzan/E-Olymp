package PW7;

import java.util.*;

@SuppressWarnings("Duplicates")
public class Banquet {

    static int[] data;
    static int[] links;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNextLine()) {
            try {
                data = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                System.out.println(decide(createAL(data)) ? "ok\n" : "fail\n");
            } catch (Exception e) {
                System.exit(0);
            }
        }
    }


    private static boolean decide(int[] data) {

        links = new int[data.length];

        for (int i = 0; i < data.length; i++) {
            System.out.println("-------------------------------");
            while (data[i] > 0) {
                int j = min(i);
                System.out.println("MIN:" + j);
                if (j == -1) return false;
                connect(i, j);
                System.out.println("connected!");
                System.out.println("data[" + i + "]: " + data[i] + ", data[" + j + "]: " + data[j]);

            }

        }
        return true;
    }

    private static int min(int k) {
        int min = Integer.MAX_VALUE;
        int index = -1;

        for (int i = k + 1; i < data.length; i++) {
            if (data[i] == 0) continue;
//            return  i;
            if (links[i] < min) {
                min = links[i];
                index = i;
            }
        }
        if (index == -1) return -1;
        return index;
    }

    private static void connect(int i, int j) {
        data[i]--;
        data[j]--;
        links[i]++;
        links[j]++;
    }
//                for (int j = i + 1; j < data.length - i - 1; j++) {
//                    if (data[i] == 0) {
//                        System.out.println("BREAK");
//                        break;
//                    }
//                    System.out.println("---------------");
//                    System.out.println("data[" + i + "]: " + data[i] + ", data[" + j + "]: " + data[j]);
//                    if (data[j] > 0) {
//                        connect(i, j);
//                        System.out.println("connected!");
//                        links[i]++;
//                        links[j]++;
//                        System.out.println("data[" + i + "]: " + data[i] + ", data[" + j + "]: " + data[j]);
//                    }
//                    System.out.println("---------------");
//                }
//
//                System.out.println("-------------------------------");
//                if (data[i] > 0) {
//                    System.out.println(Arrays.toString(data));
//                    return false;
//                }
//            }


    private static ArrayList<Integer> createAL(int[] data) {
        ArrayList<Integer> data1 = new ArrayList<>();

        for (int i = 0; i < data.length; i++) {
            data1.add(data[i]);
        }
        return data1;
    }

    private static void printPQ(PriorityQueue<Integer> pQueue) {
        PriorityQueue<Integer> newPQ = new PriorityQueue<>(pQueue);
        System.out.print("[");
        for (int i = 0; i < pQueue.size(); i++) {
            System.out.print(newPQ.poll() + ", ");
        }
        System.out.print("\b\b]\n");
    }

    static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    private static boolean decide(ArrayList<Integer> data) {
        PriorityQueue<Integer> q = new PriorityQueue<>(new MyComparator());
        q.addAll(data);
//        printPQ(q);
        while (!q.isEmpty()) {
//            System.out.println("-----------------");
            int v = q.peek();
//            System.out.println("New peek: " + v);
            q.poll();
//            printPQ(q);
            ArrayList<Integer> add = new ArrayList<>();
            while (v > 0) {
                if (q.isEmpty()) return false;
                if (q.peek() != 1) {
                    add.add(q.peek() - 1);
//                    System.out.println(add.toString());
                }
                q.poll();
//                printPQ(q);
                v--;
            }
//            System.out.println("-----------------");
            while (!add.isEmpty()) {
                q.addAll(add);
//                printPQ(q);
                add = new ArrayList<>();
            }
//            System.out.println("-----------------");

        }
        return true;
    }
}
