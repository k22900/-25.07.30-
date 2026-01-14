import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int[] dx = new int[]{-2, -1, 1, 2, 2, 1,-1,-2};//상,우,하,좌
    static final int[] dy = new int[]{1, 2, 2, 1, -1, -2, -2,-1};
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
//        System.setIn(new FileInputStream("src/B7562input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());//테스트 케이스 개수
        for (int g = 0; g < n; g++) {
            int len = Integer.parseInt(br.readLine());//체스판 크기는 X,Y가 같다 그래서 len으로 통합
            int[][] grid = new int[len][len];
            boolean[][] dist = new boolean[len][len];
            for (int i = 0; i < len; i++) {
                Arrays.fill(grid[i], 0);//체스판 채우기
                Arrays.fill(dist[i], false);//초기방문 여부 채우기
            }
            st=new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());

            st=new StringTokenizer(br.readLine());
            int tx = Integer.parseInt(st.nextToken());
            int ty = Integer.parseInt(st.nextToken());
            bfs(grid, dist, sx, sy, len);
            System.out.println(grid[tx][ty]);
        }
    }

    static void bfs(int[][] grid, boolean[][] dist, int x, int y,int size) {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x,y});

        while (!que.isEmpty()) {
            int[] cur= que.poll();
            int cx = cur[0];
            int cy = cur[1];
            dist[cx][cy] = true;
            int cnt = grid[cx][cy]+1;


            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (indexOutOfRange(nx,ny,size)) continue;
                if (dist[nx][ny]) continue;

                dist[nx][ny] = true;
                que.add(new int[]{nx, ny});
                grid[nx][ny] = cnt;

            }
        }
    }

    static boolean indexOutOfRange(int x, int y, int range) {
        return x < 0 || x > range-1 || y < 0 || y > range-1;
    }
}