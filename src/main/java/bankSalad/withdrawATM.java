package bankSalad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class withdrawATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int amount = Integer.parseInt(st.nextToken()); // 잔액
        int count = Integer.parseInt(st.nextToken()); // 출금횟수
        int tryCount = 0;
        // 출금시도금액
        for (int i = 0; i < count; i++) {
            tryCount++;
            int tryAmount = Integer.parseInt(br.readLine().trim());
            if (tryCount > 3) {
                sb.append("횟수 초과").append("\n");
            } else if (tryAmount % 10000 != 0) {
                sb.append("단위 오류").append("\n");
            } else if (tryAmount >= 300000) {
                sb.append("한도 초과").append("\n");
            } else if (tryAmount > amount) {
                sb.append("잔액 부족").append("\n");
            } else {
                int remainAmt = amount - tryAmount;
                sb.append("출금 성공 잔액: ").append(remainAmt).append("\n");
                amount = remainAmt;
            }

        }
        System.out.println(sb);
    }
}
