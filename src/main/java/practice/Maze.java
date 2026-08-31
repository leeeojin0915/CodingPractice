package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Maze {
    static int N, M;
    static int[][] maze;
    static boolean[][] visited;
    // 상하좌우 이동
    static int[] dy = {-1, 1, 0, 0}; //상,하
    static int[] dx = {0, 0, -1, 1}; //좌,우

    static int bfs(int StartY, int StartX) {
        // LinkedArrayList 보다
        Deque<int[]> deque = new ArrayDeque<>();
        // 시작점 삽입
        deque.offer(new int[]{StartY, StartX, 1});
        visited[StartY][StartX] = true;

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            System.out.println("cur" + Arrays.toString(cur));
            int y = cur[0], x = cur[1], dist = cur[2];

            //도착점체크
            if (y == N - 1 && x == M - 1) return dist;

            // 4방향 탐색
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                // 범위 벗어나면 스킵
                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                // 이미 방문 했으면 스킵
                if (visited[ny][nx]) continue;
                // 벽이면 스킵( 0=벽)
                if (maze[ny][nx] == 0) continue;

                visited[ny][nx] = true;
                //다음 칸 삽입, 거리 + 1
                deque.offer(new int[]{ny, nx, dist + 1});
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        // Scanner 보다 빠르다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 한 줄을 공백기준으로 나눠줌
        StringTokenizer st = new StringTokenizer(br.readLine());
        // string 한꺼번에 모아서 출력
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                // '0' 빼서 문자 -> 숫자 변환 ('1'-'0' = 1)
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        sb.append(bfs(0, 0));
        System.out.println(sb);
    }
}
