import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

//둘의 현재 위치는 N=수빈 K=동생 현재위치가 X
//이동방법=걷기 는 X-1또는X+1 순간이동= X*2 로이동 모든 1회이동시간은 1로 잡는다
public class Main {


    static int start;
    static int end;
    static int[] dist = new int[100_001];
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/B1697input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        Arrays.fill(dist,-1);
        bfs();
        System.out.println(dist[end]);

    }

    static void bfs() {
        Queue<Integer> que = new ArrayDeque<>();
        dist[start] = 0;
        que.add(start);

        while (!que.isEmpty()) {

            int X = que.poll();
            int nextDist = dist[X] + 1;
            int back = X - 1;
            int front = X + 1;
            int teleportation = 2 * X;
            int[] list = new int[]{teleportation, front, back};

            for (int i : list) {
                if (outOfRange(i)) continue;
                if (dist[i] != -1) continue;

                dist[i] = nextDist;
                que.add(i);
            }
        }
    }

    static boolean outOfRange(int x) {
        return x<0||x>100000;
    }
}
