package practice;

import java.util.Scanner;

public class SumOfNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] first = sc.nextLine().trim().split(" ");
        int n = Integer.parseInt(first[0]); // 배열의 크기
        int m = Integer.parseInt(first[1]); // 목표 합

        String[] second = sc.nextLine().trim().split(" ");

        for (int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++){
                int sum = Integer.parseInt(second[i]) + Integer.parseInt(second[j]);
                if(sum == m){
                    System.out.println(i + " " + j);
                    System.out.println(second[i] + " " + second[j]);
                }
            }
        }
    }
}
