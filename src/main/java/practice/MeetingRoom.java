package practice;

import java.util.Arrays;
import java.util.Scanner;

public class MeetingRoom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = Integer.parseInt(sc.nextLine().trim());

        int[][] arr = new int[first][2];

        for (int i = 0; i < first; i++) {
            String[] line = sc.nextLine().trim().split(" ");
            arr[i][0] = Integer.parseInt(line[0]);
            arr[i][1] = Integer.parseInt(line[1]);
        }
        System.out.println(Arrays.deepToString(arr));

        // 정렬
        Arrays.sort(arr, (o1, o2) -> o1[1]-o2[1]);

        System.out.println(Arrays.deepToString(arr));

        int count =0;
        int lastMeet= -1;

        for(int[] meet : arr){
           if(meet[0] >= lastMeet){
               count++;
               lastMeet = meet[1];
           }
        }
        System.out.println(count);
    }
}
