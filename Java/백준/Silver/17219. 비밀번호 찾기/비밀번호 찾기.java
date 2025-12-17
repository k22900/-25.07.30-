import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, String> passwordList = new HashMap<>();//사이트목록
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        StringTokenizer l = new StringTokenizer(num);
        int n = Integer.valueOf(l.nextToken());
        int m = Integer.valueOf(l.nextToken());
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
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