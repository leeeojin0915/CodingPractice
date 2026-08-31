package practice;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfInternal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] first = sc.nextLine().trim().split(" "); // 배열크기, 퉈리수
        int N = Integer.parseInt(first[0]);
        int M = Integer.parseInt(first[1]);

        String[] second = sc.nextLine().trim().split(" "); // 배열
        int[] arr = new int[N+1];

        for(int i =1;i<=N;i++){
            arr[i] = Integer.parseInt(second[i-1]); // 배열 파싱
        }
        System.out.println(Arrays.toString(arr));

        // 2. 누적합 배열 만들기
        int[] prefix = new int[N+1];
        for(int i=1;i<=N;i++){
            prefix[i] = prefix[i-1]+arr[i];
        }
        System.out.println(Arrays.toString(prefix));

        // 3. 누적 쿼리
        for(int i=0;i< M;i++){
            String[] query = sc.nextLine().trim().split(" ");
            int a = Integer.parseInt(query[0]);
            int b = Integer.parseInt(query[1]);
            System.out.println(prefix[b]-prefix[a-1]);
        }
    }
}
