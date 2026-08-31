package practice;

import java.util.Scanner;

public class FindXOfSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] first = sc.nextLine().trim().split(" ");
        int n = Integer.parseInt(first[0]);
        int target = Integer.parseInt(first[1]);

        String[] arr = sc.nextLine().trim().split(" ");
        int sum = 0;
        int left = 0;
        int count =0;

        for (int right = 0; right < n; right++) {
            sum += Integer.parseInt(arr[right]); //구간 늘리기

            while (sum > target){
                sum -= Integer.parseInt(arr[left]);
                left++;
                System.out.println("left::"+sum);
            }

            if(sum == target) count++;
            System.out.println("target:"+sum);

        }
        System.out.println(count);

    }
}
