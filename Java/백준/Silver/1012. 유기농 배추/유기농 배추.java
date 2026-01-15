import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static boolean[][] grid;
    static final int[] dx = new int[]{0, 1, 0, -1};
    static final int[] dy = new int[]{1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/inputB1012.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            grid = new boolean[n][m];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int tx = Integer.parseInt(st.nextToken());
                int ty = Integer.parseInt(st.nextToken());
                grid[tx][ty] = true;
            }
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int l = 0; l < m; l++) {
                    if (!grid[i][l]) continue;
                    bfs(i, l);
                    cnt++;
                }
            }
            System.out.println(cnt);

        }

    }

    static void bfs(int x,int y) {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y});
        grid[x][y] = false;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (outOfRange(nx, ny)) continue;
                if (!grid[nx][ny]) continue;

                grid[nx][ny] = false;
                que.add(new int[]{nx, ny});
            }
        }

    }

    static boolean outOfRange(int x, int y) {
        return x < 0 || x > n - 1 || y < 0 || y > m - 1;
    }
}
