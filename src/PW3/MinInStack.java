package PW3;

import java.util.Scanner;
import java.util.Stack;

public class MinInStack {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        long a = scan.nextLong();
        long b = scan.nextLong();
        long c = scan.nextLong();
        long x = scan.nextLong();
        long ans = 0, min;
        scan.close();

        Stack stack = new Stack<MyPair>();

        while (n > 0) {

            x = (a * x * x + b * x + c) / 100 % 1000000;

            if (x % 5 < 2) {
                if (!stack.empty()) stack.pop();

            } else {
                if (!stack.isEmpty()) min = x;
                else min = Math.min(x, ((MyPair) stack.peek()).value());
                stack.push(new MyPair(x, min));
            }
            if (!stack.isEmpty()) ans += ((MyPair) stack.peek()).value();
            n--;
        }
        System.out.println(ans);
    }

    static class MyPair {
        private final Long key;
        private final Long value;

        public MyPair(Long aKey, Long aValue) {
            key = aKey;
            value = aValue;
        }

        public Long value() {
            return value;
        }

        @Override
        public String toString() {
            return key + " - " + value;
        }
    }
}
