import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int gDim;
    static int[][] grid;
    static boolean[][] visited;
    static final int[] dx = new int[]{0, 1, 0, -1};
    static final int[] dy = new int[]{1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/B2667input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gDim = Integer.parseInt(br.readLine());
        grid = new int[gDim][gDim];
        visited = new boolean[gDim][gDim];
        for (int i = 0; i < gDim; i++) {
            String[] val= br.readLine().split("");
            for (int l = 0; l < val.length; l++) {
                grid[i][l] = Integer.parseInt(val[l]);
            }
        }
        int cnt = 0;
        List<Integer> homeCnt = new ArrayList<>();
        for (int y = 0; y < gDim; y++) {
            for (int x = 0; x < gDim; x++) {
                if (grid[y][x] == 1 && !visited[y][x]){
                    homeCnt.add(bfs(x, y));
                    cnt += 1;
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(homeCnt);
        for (int i = 0; i < homeCnt.size(); i++) {
            System.out.println(homeCnt.get(i));
        }
    }

    static int bfs(int x, int y) {
        Queue<int[]> que = new ArrayDeque<>();
        visited[y][x]=true;
        que.add(new int[]{x, y});
        int cnt = 1;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (outOfRange(nx, ny)) continue;
                if (visited[ny][nx]) continue;
                if (grid[ny][nx]==0) continue;

                visited[ny][nx] = true;
                cnt += 1;
                que.add(new int[]{nx, ny});
            }
        }

        return cnt;
    }

    static boolean outOfRange(int nx, int ny) {
        return nx < 0 || nx >= gDim || ny < 0 || ny >= gDim;
    }
}
