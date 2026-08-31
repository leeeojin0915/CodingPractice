package bankSalad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class interestCalculate {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        double amount;
        double rate;
        double month;
        String type;
        double result;

        int input = Integer.parseInt(st.nextToken());
        for (int i = 0; i < input; i++) {
            String[] data = br.readLine().trim().split(" ");
            amount = Integer.parseInt(data[0]);
            rate = Integer.parseInt(data[1]);
            month = Integer.parseInt(data[2]);
            type = data[3];

            switch (type) {
                case "단리" -> {
                    result = amount + (amount * (rate / 100) * (month / 12));
                    sb.append(String.format("%.2f",result)).append("\n");
                }
                case "복리" -> {
                    // 복리방식
                    // 거듭제곱 계산하는 함수예요
                    //Math.pow(a, b) = a의 b제곱
                    result = amount * Math.pow(1 + rate / 100 / 12, month);
                    sb.append(String.format("%.2f",result)).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
