package bankSalad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class accountBook {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        HashMap<String, Long> income = new HashMap<>();
        HashMap<String, Long> withdraw = new HashMap<>();


        int count = Integer.parseInt(st.nextToken());
        for (int i = 0; i < count; i++) {
            String[] content = br.readLine().trim().split(" ");
            switch (content[0]) {
                case "INCOME" -> {
                    income.put(content[1], income.getOrDefault(content[1],0L)+Long.parseLong(content[2]));
                }
                case "EXPENSE" -> {
                    withdraw.put(content[1], withdraw.getOrDefault(content[1],0L)+Long.parseLong(content[2]));
                }
                case "QUERY" -> {
                    long in = income.getOrDefault(content[1],0L);
                    long ex = withdraw.getOrDefault(content[1],0L);
                    sb.append(content[1]).append(":").append(in-ex).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
