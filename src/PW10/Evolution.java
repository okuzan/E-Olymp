package PW10;

import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class Evolution {
    public static void main(String[] args) throws Exception {
        System.out.println(Math.pow(2, 99));
        System.out.println(Math.pow(2, 100));
        Scanner scanner = new Scanner(System.in);

        double stages = scanner.nextDouble();
        double first = scanner.nextDouble();
        double second = scanner.nextDouble();

//        if (first >= Math.pow(2, stages) || first < Math.pow(2, stages - 1)
//                || second >= Math.pow(2, stages) || second < Math.pow(2, stages - 1)) throw new Exception();

        double s = (answer(first, second));
        System.out.printf("%.0f", s);
    }

    private static double answer(double first, double second) throws Exception {

        if (second == first) if(second == 0)  throw new Exception();

        double frank = rank(first);
//        System.out.println(frank);
        double srank = rank(second);
//        System.out.println(srank);

        while(frank > srank){
            first = Math.floor(first / 2);
            frank--;
        }

        while (srank > frank){
            second = Math.floor(second / 2);
            srank--;
        }

        while (second != first) {
            first = Math.floor(first / 2);
            second = Math.floor(second / 2);
        }

        return first;
    }

    private static double rank(double first) {
        return Math.floor(Math.log(first) / Math.log(2)) + 1;
    }
}

