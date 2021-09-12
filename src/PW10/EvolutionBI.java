package PW10;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class EvolutionBI {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        BigInteger stages = scanner.nextBigInteger();
        BigInteger first = scanner.nextBigInteger();
        BigInteger second = scanner.nextBigInteger();

//        if (first >= Math.pow(2, stages) || first < Math.pow(2, stages - 1)
//                || second >= Math.pow(2, stages) || second < Math.pow(2, stages - 1)) throw new Exception();

        BigInteger s = (answer(first, second));
//        System.out.printf("%.0f", s);
        System.out.println(s);
    }

    private static BigInteger answer(BigInteger first, BigInteger second) {

//        if (second.equals(first)) if(second == 0)  throw new Exception();

        double frank = rank(first);
//        System.out.println(frank);
        double srank = rank(second);
//        System.out.println(srank);

        BigInteger two = BigInteger.valueOf(2L);

        while (frank > srank) {
            first = BigDecimal.valueOf(Math.floor(first.divide(two).doubleValue())).toBigInteger();
            frank--;
        }

        while (srank > frank) {
            second = BigDecimal.valueOf(Math.floor(second.divide(two).doubleValue())).toBigInteger();
            srank--;
        }

        while (!second.equals(first)) {
            first = BigDecimal.valueOf(Math.floor(first.divide(two).doubleValue())).toBigInteger();
            second = BigDecimal.valueOf(Math.floor(second.divide(two).doubleValue())).toBigInteger();
        }

        return first;
    }

    private static double rank(BigInteger first) {
        return Math.floor(Math.log(first.doubleValue()) / Math.log(2)) + 1;
    }
}

