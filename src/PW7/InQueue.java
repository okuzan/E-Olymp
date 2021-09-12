package PW7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class InQueue {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int nQ = scanner.nextInt();
        int nPaydesks = scanner.nextInt();

        int[] time = new int[nQ];

        for (int i = 0; i < nQ; i++) {
            time[i] = scanner.nextInt();
        }

        System.out.println(computeTime(time, nPaydesks));

    }

    private static Integer computeTime(int[] time, int nPaydesks) {
//        InQueue pq = new InQueue();

        int answer = 0;

        int[] timeLeft = new int[nPaydesks];

        int clientsLeft = time.length;

        if (clientsLeft <= nPaydesks) {
            Arrays.sort(time);
            answer += time[time.length - 1];
            System.out.println(time[0] + " MAX");
            return answer;
        }

        for (int i = 0; i < nPaydesks; i++) {
            timeLeft[i] = time[i];
            clientsLeft--;
        }

        System.out.println(Arrays.toString(timeLeft));

        while (true) {

            System.out.println("clients left: " + clientsLeft);

            ArrayList<Integer> al = findMind(timeLeft);
            System.out.println(Arrays.toString(al.toArray()) + "@");

            int min = timeLeft[al.get(0)];
            System.out.println("MIN:" + min + " index: " + al.get(0));

            for (int k = 0; k < nPaydesks; k++) {
                System.out.println("queue" + k + ": " + timeLeft[k] + ", minus " + min);
                timeLeft[k] -= min;
            }
            answer += min;

            System.out.println(Arrays.toString(timeLeft));

            for (int j = 0; j < al.size(); j++) {
                if (clientsLeft > 0) {
                    timeLeft[al.get(j)] += time[time.length - clientsLeft];
                    System.out.println(Arrays.toString(timeLeft));
                    System.out.println("ADDED");
                    clientsLeft--;
                    System.out.println("clients left: " + clientsLeft);

                }
//                else {
//                    System.out.println("FINAL: ");
//                    Arrays.sort(timeLeft);
//                    answer += timeLeft[0];
//                    System.out.println(timeLeft[0] + " MAX");
//                    break;
//                }

//                System.out.println();
            }
            if (clientsLeft == 0) {
                Arrays.sort(timeLeft);
                answer += timeLeft[timeLeft.length - 1];
                System.out.println(timeLeft[0] + " MAX");
                break;
            }
        }
//        System.out.println(min);

        return answer;
    }

    private static ArrayList<Integer> findMind(int[] arr) {

      System.out.println(Arrays.toString(arr) + " inserted");

      int temp = arr[0];

      System.out.println(temp+ "     temp");

        ArrayList<Integer> min = new ArrayList<>();
        min.add(0);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < temp) {
                temp = i;
                min = new ArrayList<>();
                System.out.println(i);
                min.add(i);
                System.out.println(Arrays.toString(min.toArray())+ "@@@");
            } else if (arr[i] == temp) {
                min.add(i);
                System.out.println(Arrays.toString(min.toArray())+ "@@@");
            }
        }

        return min;
    }
}
