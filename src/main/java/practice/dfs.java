package practice;

import java.util.Scanner;

public class dfs {
    static boolean[][] visited; // 방문 확인
    static int[] dx = {-1, 1, 0, 0}; //상,하
    static int[] dy = {0, 0, -1, 1}; //좌,우
    static int[][] maze; // 섬 모양
    static int a, b; //행 열

    // 연결된 땅 방문 (dfs는 재귀함수로 구현)
    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i]; //
            int ny = y + dy[i];
            if (nx >= 0 && nx < a
                    && ny >= 0 && ny < b
                    && maze[nx][ny] == 1
                    && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] start = sc.nextLine().trim().split(" ");
        a = Integer.parseInt(start[0]); // 행
        b = Integer.parseInt(start[1]); // 열

        maze = new int[a][b];
        visited = new boolean[a][b];

        // 배열
        for (int i = 0; i < a; i++) {
            String input = sc.nextLine().trim(); // 110011
            for (int j = 0; j < b; j++) {
                maze[i][j] = input.charAt(j) - '0';// 문자 -> 숫자
            }
        }
        //System.out.println(Arrays.deepToString(maze));

        // 섬 개수
        int count = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (maze[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        System.out.println(count);


    }
}
