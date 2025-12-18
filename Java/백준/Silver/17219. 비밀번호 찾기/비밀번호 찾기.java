import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        Map<String, String> passwordList = new HashMap<>();//사이트목록
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        st = new StringTokenizer(num);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            st = new StringTokenizer(line);
            String siteName = st.nextToken();
            String password = st.nextToken();
            passwordList.put(siteName, password);
        }
        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            String result = passwordList.get(line);
            System.out.println(result);
        }


    }
}