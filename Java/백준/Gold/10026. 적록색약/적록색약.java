import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int gDim;
    static char[][] grid;
    static boolean[][] visited;
    static final int[] dx = new int[]{0, 1, 0, -1};
    static final int[] dy = new int[]{1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/B10026input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gDim = Integer.parseInt(br.readLine());
        grid = new char[gDim][gDim];
        visited = new boolean[gDim][gDim];
        for (int i = 0; i < gDim; i++) {
            grid[i] = br.readLine().toCharArray();
        }
        int cnt = 0;
        int rgclCnt = 0;
        for (int i = 0; i < gDim; i++) {
            for (int l = 0; l < gDim; l++) {
                if (!visited[i][l]) {
                    char color = grid[i][l];
                    bfs(color, l, i);
                    cnt += 1;
                    if (color == 'B') {
                        rgclCnt += 1;
                    }

                }
            }
        }
        for (int i = 0; i < gDim; i++) {
            for (int l = 0; l < gDim; l++) {
                if ( visited[i][l] && rgcl(l, i)) {
                    char color = grid[i][l];

                    grclBfs(l, i);
                    rgclCnt += 1;
                }
            }
        }
        System.out.println(cnt+" "+rgclCnt);

    }

    static void bfs(char color, int x, int y) {
        Queue<int[]> que = new ArrayDeque<>();
        visited[y][x] = true;
        que.add(new int[]{x, y});

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (outOfRange(nx, ny)) continue;
                if (visited[ny][nx]) continue;
                if (grid[ny][nx] != color) continue;

                visited[ny][nx] = true;

                que.add(new int[]{nx, ny});
            }
        }
    }

    static void grclBfs(int x, int y) {
        Queue<int[]> que = new ArrayDeque<>();
        visited[y][x] = false;
        que.add(new int[]{x, y});

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (outOfRange(nx, ny)) continue;
                if (!visited[ny][nx]) continue;
                if (grid[ny][nx] == 'B') continue;

                visited[ny][nx] = false;

                que.add(new int[]{nx, ny});
            }
        }
    }

    static boolean rgcl(int x, int y) {
        char color = grid[y][x];
        return color=='R'||color=='G';
    }

    static boolean outOfRange(int nx,int ny) {
        return nx < 0 || nx >= gDim || ny < 0 || ny >= gDim;
    }
}
