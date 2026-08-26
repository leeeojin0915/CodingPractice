import java.util.Arrays;
import java.util.Scanner;

public class ContinueMaxExpend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 첫 줄: N이랑 K 같이 파싱
        String[] firstLine = sc.nextLine().trim().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int k = Integer.parseInt(firstLine[1]);

        // 둘째 줄: 공백으로 나눠서 배열에 넣기
        String[] secondLine = sc.nextLine().trim().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(secondLine[i]);
        }

        System.out.println("첫 줄: 날 수 " + n + ", 구간 크기 " + k);
        System.out.println("둘째 줄:" + Arrays.toString(arr));

        int count = n - k + 1;
        long max = 0;
        for (int i = 0; i < count; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            if (sum > max) {
                max = sum;
            }
        }
        System.out.println(max);
    }
}
