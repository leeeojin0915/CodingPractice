package bankSalad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ExchangeRate {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(st.nextToken()); // 통화 수
        HashMap<String, Double> map = new HashMap<>();
        for (int i = 0; i < count; i++) {
            String[] exchangeName = br.readLine().trim().split(" ");
            map.put(exchangeName[0], Double.valueOf(exchangeName[1]));
        }
        System.out.println(map);

        int changeCount = Integer.parseInt(br.readLine().trim()); // 변환 요청 수
        for (int i = 0; i < changeCount; i++) {
            String[] requestData = br.readLine().trim().split(" ");
            int amount = Integer.parseInt(requestData[0]);
            Double exStart = map.get(requestData[1]);
            Double exEnd = map.get(requestData[2]);

            Double result = (amount/exStart) * exEnd;
            sb.append(String.format("%.2f", result)).append("\n"); // 소수점 둘째자리
        }
        System.out.println(sb);
    }
}
