import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int[] dx = new int[]{0, 1, 0, -1};
    static final int[] dy = new int[]{1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
//        System.setIn(new FileInputStream("src/B1926input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[][] grid = new int[x][y];
        boolean[][] dist = new boolean[x][y];

        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int l = 0; l < y; l++) {
                int n = Integer.parseInt(st.nextToken());
                grid[i][l] = n;
                dist[i][l] = false;
            }
        }
        int cnt = 0;
        int maxNum = 0;

        for (int i = 0; i < x; i++) {
            for (int l = 0; l < y; l++) {
                if (grid[i][l] == 1 && !dist[i][l]) {
                    int c = bfs(grid, dist, i, l, x, y);
                    cnt++;
                    maxNum = Math.max(c, maxNum);
                }
            }
        }

        System.out.println(cnt);
        System.out.println(maxNum);
    }


    static int bfs(int[][] grid, boolean[][] dist, int sx, int sy, int x, int y) {
        int cnt = 1;
        Queue<int[]> que = new ArrayDeque<>();
        dist[sx][sy] = true;
        que.add(new int[]{sx,sy});

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int cx = cur[0];
            int cy = cur[1];
            dist[cx][cy] = true;


            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (indexOutOfRange(nx, ny, x, y)) continue;
                if (dist[nx][ny]) continue;
                if (grid[nx][ny] == 0) continue;

                dist[nx][ny] = true;
                que.add(new int[]{nx, ny});
                cnt++;
            }
        }

        return cnt;
    }

    static boolean indexOutOfRange(int nx, int ny, int x, int y) {
        return nx < 0 || nx > x - 1 || ny < 0 || ny > y - 1;
    }
}

