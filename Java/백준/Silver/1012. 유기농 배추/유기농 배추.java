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
//        System.setIn(new FileInputStream("src/inputB1012.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {//확인의 초기점
            st = new StringTokenizer(br.readLine());//i번째 테스트 케이스의 격자값
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            int[][] grid = new int[x][y];
            for (int l = 0; l < x; l++) {
                Arrays.fill(grid[l],0);
            }

            boolean[][] dist = new boolean[x][y];//방문여부
            for (int l = 0; l < x; l++) {
                Arrays.fill(dist[l],true);
            }

            Set<Integer> gridSet = new HashSet<>();
            for (int l = 0; l < num; l++) {
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                grid[cx][cy] = 1;
                gridSet.add(cx * y + cy);
                dist[cx][cy] = false;

            }

            int cnt = 0;
            while (!gridSet.isEmpty()) {
                int startPoint = gridSet.iterator().next();
                gridSet.remove(startPoint);

                int sx = startPoint / y;
                int sy = startPoint % y;

                bfs(grid, gridSet, dist, x, y, sx, sy);
                cnt++;
            }
            System.out.println(cnt);
        }
    }

    static void bfs(int[][] grid, Set<Integer> gridSet,boolean[][] dist, int x, int y,int sx, int sy) {

        Queue<int[]> que = new ArrayDeque<>();
        dist[sx][sy] = true;
        que.add(new int[]{sx,sy});
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int cx = cur[0];
            int cy = cur[1];
            dist[cx][cy] = true;
            gridSet.remove(cx * y + cy);

            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (indexOutOfRange(nx, ny, x, y)) continue;
                if (grid[nx][ny]==0) continue;
                if (dist[nx][ny]) continue;

                dist[nx][ny] = true;

                gridSet.remove(nx * y + ny);

                que.add(new int[]{nx,ny});
            }

        }

    }

    static boolean indexOutOfRange(int nx, int ny, int x, int y) {
        return nx < 0 || nx > x-1 || ny < 0 || ny > y-1;
    }
}
