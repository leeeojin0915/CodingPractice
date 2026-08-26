import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PayConfirm {
    static Map<String, int[]> userBalance = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) break;
            String[] parts = line.split(" ");
            String cmd = parts[0];
            System.out.println("첫줄::" + cmd);
            userBalance.put(parts[1], new int[]{Integer.parseInt(parts[2]), Integer.parseInt(parts[3])});

            String name;
            long a = userBalance.get(parts[1])[0];
            long b = userBalance.get(parts[1])[1];


            double balance = ((double) b / a) * 100.0;
            System.out.println("result::" + balance + "%");

            if (balance >= 80.0 && balance <= 100.0) {
                System.out.println("경고");
            } else if (balance > 100.0) {
                System.out.println("초과");
            } else if (balance < 80.0) {
                System.out.println("정산");
            }

        }
    }
}
