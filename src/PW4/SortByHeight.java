package PW4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class SortByHeight {

    private static void answer() throws IOException {
        int ans = 0;
        int[] arrHeights;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1024);
        String line;

        while (( line = reader.readLine()) != null) {
            if (!line.matches("\\d+")) break;
            int size = Integer.parseInt(line);

            arrHeights = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] borders = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int low = borders[0];
            int up = borders[1];

            int c = 0;
            for (int i : arrHeights) {
                if (c < size) if (i >= low && i <= up) ans++;
                c++;
            }
            System.out.println(ans);
            ans = 0;
        }
        reader.close();
    }

    public static void main(String[] args) throws IOException {
        answer();
    }
}