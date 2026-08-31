package practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] first = sc.nextLine().trim().split(" ");
        int a = Integer.parseInt(first[0]); // 행
        int b = Integer.parseInt(first[1]); // 열

        int[][] arr = new int[a][b];
        for (int i = 0; i < a; i++) {
            String line = sc.nextLine().trim(); // 101010
            for (int j = 0; j < b; j++) {
                arr[i][j] = line.charAt(j) - '0'; // 문자 -> 숫지
            }
        }
        System.out.println(Arrays.deepToString(arr));

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[a][b];

        queue.add(new int[]{0,0,1}); // 시작점 , 거리 1
        visited[0][0] = true;

        int[] dx = {-1, 1, 0, 0}; // 상하
        int[] dy = {0, 0, -1, 1}; // 좌우

        while (!queue.isEmpty()) {
            int[] cur = queue.poll(); // 꺼내기
            int x = cur[0];          // 행
            int y = cur[1];          // 열
            int dist = cur[2];       // 거리

            // 도착!
            if (x == a-1 && y == b-1) {
                System.out.println(dist);
                return;
            }

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 안 && 벽 아님 && 방문 안 했음
                if (nx >= 0 && nx < a
                        && ny >= 0 && ny < b
                        && arr[nx][ny] == 1
                        && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, dist + 1});
                }
            }
        }
    }
}
