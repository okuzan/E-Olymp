package PW7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class HeapQueue {

    static ArrayList<Long> heap = new ArrayList<>();

    static int tmp;
    static int size = 0;
    static long maximal;

    static void swap(int a, int b) {
        long t = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, t);
    }

    static void heapify(int index) {
        if (index * 2 + 1 <= size) {
            tmp = index * 2;
            tmp += (heap.get(index * 2) > heap.get(index * 2 + 1)) ? 1 : 0;
            if (heap.get(index) > heap.get(tmp)) {
                swap(index, tmp);
                heapify(tmp);
            }
        } else if (index * 2 <= size && heap.get(index) > heap.get(index * 2)) {
            swap(index, index * 2);
            heapify(index * 2);
        }
    }

    static void push(long x) {
        size++;
        heap.add(size, x);
        tmp = size;
        Collections.sort(heap);
    }

    public static void main(String[] args) {
        heap.add(0, 0L);
        Scanner scanner = new Scanner(System.in);
        int nQ = scanner.nextInt();
        int nPaydesks = scanner.nextInt();

        long[] time = new long[nQ];

        for (int i = 0; i < nQ; i++) {
            time[i] = scanner.nextLong();
        }

        long answer = 0;

        if (nQ <= nPaydesks) {
            Arrays.sort(time);
            answer = (int) time[time.length - 1];

        } else {
            for (int i = 0; i < nPaydesks; i++) {
                push(time[i]);
            }
            for (int i = nPaydesks; i < nQ; i++) {
                System.out.println("----------------------------");
                System.out.println(Arrays.toString(heap.toArray()));
                heap.set(1, heap.get(1) + time[i]);
                System.out.println(Arrays.toString(heap.toArray()));
                Collections.sort(heap);
                System.out.println(Arrays.toString(heap.toArray()));
                System.out.println("----------------------------");
            }

            System.out.println(Arrays.toString(heap.toArray()));

            for (int i = 1; i <= size; i++) maximal = Math.max(maximal, heap.get(i));
            answer += maximal;
            System.out.println("Answer:" + answer);

        }
        System.out.println(answer);
    }
}