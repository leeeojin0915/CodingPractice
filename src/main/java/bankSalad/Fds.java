package bankSalad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Fds {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int transCount = Integer.parseInt(st.nextToken());
        long amount = 0;
        List<String[]> list = new ArrayList<>();

        for (int i = 0; i < transCount; i++) {
            String[] line = br.readLine().trim().split(" ");
            amount += Integer.parseInt(line[1]);
            list.add(i,line);
        }

        long average = amount / transCount;
        long max = average * 5;
        System.out.println(average);
        System.out.println(max);

        for (String[] data : list) {
            if (max < Long.parseLong(data[1])) {
                sb.append(data[0]).append(" ").append(data[1]);
            }
        }
        System.out.println(sb);
    }
}
