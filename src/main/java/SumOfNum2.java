import javax.swing.*;
import java.util.HashMap;
import java.util.Scanner;

public class SumOfNum2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //첫번째
        String[] first = sc.nextLine().trim().split(" ");
        int n = Integer.parseInt(first[0]);
        int target = Integer.parseInt(first[1]);

        String[] second = sc.nextLine().trim().split(" ");
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int current = Integer.parseInt(second[i]);
            int partner = target - current;

            if (map.containsKey(partner)) {
                System.out.println(map.get(partner) + "::" + i);
                return;
            } else {
                map.put(Integer.parseInt(second[i]), i);
            }

        }
        System.out.println(map);
    }
}
