package practice;

import java.util.Scanner;

public class PayConfirm2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split(" ");
            String name = parts[0];
            int a = Integer.parseInt(parts[1]);
            int b = Integer.parseInt(parts[2]);

            double balance = ((double) b / a) * 100.0;

            System.out.println(name + " " + balance + "%");

            String status;
            if (balance >= 80.0 && balance <= 100.0) {
                status = "경고";
            } else if (balance > 100.0) {
                status = "초과";
            } else {
                status = "정산";
            }

            sb.append(name).append(" ").append(status).append("\n");
        }
        System.out.println(sb);

    }
}
