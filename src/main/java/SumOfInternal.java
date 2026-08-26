import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfInternal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] first = sc.nextLine().trim().split(" "); // 배열크기, 퉈리수
        int M = Integer.parseInt(first[1]);
        String[] second = sc.nextLine().trim().split(" ");
        String[] arr = new String[M];

        for(int i =1;i<M;i++){
            arr = sc.nextLine().trim().split(" ");
            System.out.println(Arrays.deepToString(arr));
        }
    }
}
