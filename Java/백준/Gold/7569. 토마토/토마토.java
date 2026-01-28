import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/* 입력
첫줄 x값=M y값=N 상자수z=H
둘째 부터 상자에 들어갈 값
출력
최소시간 또는 전부 안익을시 -1
*/

public class Main {
    static int[][][] grid;
    static int[][][] dist;
    static final int MAX_VAL = Integer.MAX_VALUE;
    static final int[] dx = new int[]{0, 0, 1, 0, -1, 0};
    static final int[] dy = new int[]{0, 0, 0, 1, 0, -1};
    static final int[] dz = new int[]{-1, 1, 0, 0, 0, 0};
    static int x;
    static int y;
    static int z;
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/B7569input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        z = Integer.parseInt(st.nextToken());

        grid = new int[z][y][x];
        dist = new int[z][y][x];
        List<int[]> startPoint = new ArrayList<>();
        for (int i = 0; i < z; i++) {
            for (int l = 0; l < y; l++) {
                st = new StringTokenizer(br.readLine());
                Arrays.fill(dist[i][l],MAX_VAL);//방문?걸린시간 기록용 기본값 채우고
                for (int j = 0; j < x; j++) {
                    int val = Integer.parseInt(st.nextToken());
                    grid[i][l][j] = val;//격자에 각위치에 토마토 값
                    if (val == 1) {
                        int[] stVal = new int[]{j, l, i};
                        startPoint.add(stVal);
                        dist[i][l][j] = 0;
                    }
                }
            }
        }
        bfs(startPoint);

        int result = 0;
        for (int cz = 0; cz < z; cz++) {
            if (result == -1) break;
            for (int cy = 0; cy < y; cy++) {
                if (result == -1) break;
                for (int cx = 0; cx < x; cx++) {
                    int v = dist[cz][cy][cx];
                    if (v != MAX_VAL) {
                        result = Math.max(v, result);
                    } else if (grid[cz][cy][cx]==0) {
                        result = -1;
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }

    static void bfs(List<int[]> stList) {
        Queue<int[]> que = new ArrayDeque<>();
        for (int i = 0; i < stList.size(); i++) {
            int[] val = stList.get(i);
            que.add(val);
        }

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cz = cur[2];
            int nextDist = dist[cz][cy][cx]+1;

            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nz = cz + dz[i];

                if (outOfRange(nx,ny,nz)) continue;
                if (dist[nz][ny][nx] != MAX_VAL) continue;
                if (grid[nz][ny][nx] == -1) continue;

                dist[nz][ny][nx] = nextDist;

                que.add(new int[]{nx, ny, nz});
            }

        }
    }

    static boolean outOfRange(int nx, int ny, int nz) {
        return nx < 0 || nx >= x || ny < 0 || ny >= y || nz < 0 || nz >= z;
    }
}
