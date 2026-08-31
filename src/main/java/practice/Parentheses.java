package practice;

import java.util.Scanner;

public class Parentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine().trim();
        System.out.println("data:::" + data);

        int count = 0;
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (c == '(') {
                count++;
            } else {
                count--;
            }

            if (count < 0) {
                System.out.println("false");
                return;
            }
        }
        System.out.println(count == 0);
    }
}
