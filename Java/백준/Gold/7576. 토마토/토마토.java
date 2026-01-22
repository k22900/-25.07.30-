import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {// 입력:첫줄 격자크기 둘째줄 부터 격자정보 0=안익음 1=익음 -1=없음
    static final int[] dx = new int[]{0, 1, 0, -1};
    static final int[] dy = new int[]{1, 0, -1, 0};
    static final int MAX_VAL = Integer.MAX_VALUE;
    static int[][] grid;
    static int[][] dist;
    static int x;
    static int y;
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/B7576input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        grid = new int[x][y];
        dist = new int[x][y];
        List<int[]> startPoint = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dist[i], MAX_VAL);
            for (int l = 0; l < y; l++){
                int val = Integer.parseInt(st.nextToken());
                grid[i][l] = val;
                if (val == 1){
                    startPoint.add(new int[]{i, l});//시작점 넣기}
                    dist[i][l] = 0;
                }
            }//격자채우기


        }

        int result = 0;
        bfs(startPoint);
        for (int i = 0; i < x; i++) {
            if (result == -1) break;
            for (int l = 0; l < y; l++) {
                int v = dist[i][l];
                if (v != MAX_VAL) {
                    result = Math.max(v, result);
                } else if (grid[i][l]==0){
                    result = -1;

                    break;
                }

            }
        }
        System.out.println(result);


    }
    static void bfs(List<int[]> st) {
        Queue<int[]> que = new ArrayDeque<>();
        for (int i = 0; i < st.size(); i++) {
            int[] val = st.get(i);
            que.add(val);
        }

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int cx = cur[0];
            int cy = cur[1];
            int nextDist = dist[cx][cy] + 1;

            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (outOfRange(nx,ny)) continue;
                if (dist[nx][ny] != MAX_VAL) continue;
                if (grid[nx][ny]==-1) continue;

                dist[nx][ny] = nextDist;
                que.add(new int[]{nx, ny});
            }
        }
    }

    static boolean outOfRange(int nx, int ny) {
        return nx < 0 || nx > x - 1 || ny < 0 || ny > y - 1;
    }
}
