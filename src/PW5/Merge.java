package PW5;

import java.io.*;
import java.util.Arrays;

public class Merge {

    static class MyPair implements Comparable<MyPair> {
        int key, value, index;

        MyPair(int i, int j, int k) {
            key = i;
            value = j;
            index = k;
        }

        @Override
        public int compareTo(MyPair o) {
            int c = this.key - o.key;
            return c == 0 ? this.index - o.index : c;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line);
        MyPair pairs[] = new MyPair[n];

        for (int i = 0; i < n; i++) {
            String[] curLine =  br.readLine().split(" ");
            int a = Integer.parseInt(curLine[0]);
            int b = Integer.parseInt(curLine[1]);
            pairs[i] = new MyPair(a,b,i);
        }

        Arrays.sort(pairs);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (MyPair k : pairs) bw.write(k.key + " " + k.value +"\n");
        bw.flush();

    }
}