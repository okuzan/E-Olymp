package PW8;

import java.util.PriorityQueue;
import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class Wormix {

    public static void main(String[] args) throws Exception {
//        return;
        Scanner scan = new Scanner(System.in);
        int nMissions = scan.nextInt();
        int nPoints = scan.nextInt();


        int overtime = 101;

        PriorityQueue<MyUnit> pq = new PriorityQueue<>();

        for (int i = 0; i < nMissions; i++) {
            MyUnit mu = new MyUnit(scan.nextInt(), scan.nextInt());
//            System.out.println(i);
            if (mu.points >= nPoints && mu.time < overtime) {
                overtime = mu.time;
//                throw new Exception();
//                System.out.println(overtime);
            } else
                pq.add(mu);
        }

        if (nPoints == 0) {
            System.out.println("0");
            return;
        }

        printPQ(pq);
        int size = pq.size();

        int earned = 0;
        int time = 0;
        int saved = 10001;

        for (int i = 0; i < size; i++) {
            MyUnit topU = pq.poll();
            System.out.println("Points: " + earned + ", time: " + time);

            earned += topU.points;
            time += topU.time;

            System.out.println("topU:" + topU.toString());

            if (earned >= nPoints) {
                System.out.println("Overflow!");

                if (time < saved) {
                    System.out.println("New minimum: " + time);
                    saved = time;
                }

                System.out.println("Saved: " + saved + ". Rolling back..");

                time -= topU.time;
                earned -= topU.points;
            }
            System.out.println("-------------");
        }


        int ans = time;

        if (earned < nPoints) {
            System.out.println("Not enough!");
            if (saved != 10001) {
                System.out.println("But there is saved: " + saved);
                ans = saved;

                if (overtime != 101) {
                    System.out.println("Comparing to overtime if there is such..");
                    ans = (ans < overtime) ? ans : overtime;
                }
                System.out.println(ans);
            } else {
                if (overtime != 101) {
                    System.out.println("No chance...(((");
                    System.out.println(-1);
                } else {
                    System.out.println("No saved, but, overtime:");
                    System.out.println(overtime);
                }
            }
            return;
        }

        //nPoints reached
        if (saved != 10001) ans = (saved < time) ? saved : time;
        if (overtime != 101) ans = (ans < overtime) ? ans : overtime;
        System.out.println(ans);
    }

    private static void printPQ(PriorityQueue<MyUnit> pQueue) {
        PriorityQueue newPQ = new PriorityQueue<>(pQueue);
        for (int i = 0; i < pQueue.size(); i++)
            System.out.print(newPQ.poll() + "\n");
    }

    static class MyUnit implements Comparable<MyUnit> {
        int points, time;
        double cpa;

        MyUnit(int p, int t) {
            points = p;
            time = t;
            cpa = (double) p / t;
        }

        @Override
        public String toString() {
            return "{p = " + points + ", t = " + time + ", c = " + cpa + "}";
        }

        @Override
        public int compareTo(MyUnit o) {
            double cpa = (o.cpa - this.cpa);
            int time = this.time - o.time;

            if (cpa > 0) return 1;
            if (cpa < 0) return -1;
            return -time;
        }
    }
}
