package practice;

import java.util.Arrays;
import java.util.Scanner;

public class FindOfNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] first = sc.nextLine().trim().split(" ");
        int n = Integer.parseInt(first[0]);
        int target = Integer.parseInt(first[1]);
        System.out.println(n+" "+target);

        String[] second = sc.nextLine().trim().split(" ");
        System.out.println(Arrays.deepToString(second));
        String result = "";
        for(int i =0;i<n;i++){
            int a = Integer.parseInt(second[i]);
            System.out.println(a);
            if(a==target){
                result = "true";
            }else {
                result="false";
            }
        }
        System.out.println(result);
    }
}
