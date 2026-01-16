import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] grid;
    static int[][] dist;
    static int len;
    static final int[] dx = new int[]{-2, -1, 1, 2, 2, 1,-1,-2};//상,우,하,좌
    static final int[] dy = new int[]{1, 2, 2, 1, -1, -2, -2,-1};
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        //System.setIn(new FileInputStream("src/B7562input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());//테스트 케이스 개수
        for (int g = 0; g < n; g++) {

            len = Integer.parseInt(br.readLine());//체스판 크기는 X,Y가 같다 그래서 len으로 통합
            grid = new int[len][len];
            dist = new int[len][len];
            for (int i = 0; i < len; i++) {
//                Arrays.fill(grid[i], 0);//체스판 채우기
                Arrays.fill(dist[i], -1);//초기방문 여부 채우기


            }
            st=new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());

            st=new StringTokenizer(br.readLine());
            int tx = Integer.parseInt(st.nextToken());
            int ty = Integer.parseInt(st.nextToken());
            bfs(sx, sy, len);
            sb.append(dist[tx][ty]).append("\n");

        }
        System.out.println(sb);
    }

    static void bfs(int x, int y,int len) {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x,y});
        dist[x][y] = 0;

        while (!que.isEmpty()) {
            int[] cur= que.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cnt = dist[cx][cy]+1;


            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (indexOutOfRange(nx,ny)) continue;
                if (dist[nx][ny]!=-1) continue;

                dist[nx][ny] = cnt;
                que.add(new int[]{nx, ny});


            }
        }
    }

    static boolean indexOutOfRange(int x, int y) {
        return x < 0 || x > len-1 || y < 0 || y > len-1;
    }
}
