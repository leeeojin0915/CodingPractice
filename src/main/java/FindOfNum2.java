import java.util.Arrays;
import java.util.Scanner;

public class FindOfNum2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] first = sc.nextLine().trim().split(" ");
        int n = Integer.parseInt(first[0]);
        int target = Integer.parseInt(first[1]);

        String[] second = sc.nextLine().trim().split(" ");
        int left = 0; // 맨처음 인덱스
        int right = n - 1; //마지막 인덱스

        while (left <= right) {
            int id = (left + right) / 2; // 가운데 인덱스
            System.out.println("index::" + id);

            if (Integer.parseInt(second[id]) == target) {
                System.out.println("true");
                return;
            } else if (Integer.parseInt(second[id]) < target) {
                left = id + 1;
            } else {
                right = id - 1;
            }
        }
        System.out.println("false");
    }
}
