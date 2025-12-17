import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Set<String> listParticipants = new LinkedHashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        StringTokenizer n = new StringTokenizer(num);
        int k = Integer.valueOf(n.nextToken());
        int l = Integer.valueOf(n.nextToken());
        for (int i = 0; i < l; i++) {
            String  studentNum = br.readLine().trim();
            if (listParticipants.contains(studentNum)) {
                listParticipants.remove(studentNum);
            }

            listParticipants.add(studentNum);
        }
        int cnt = 0;
        for (String student : listParticipants) {
            if (cnt == k) {
                break;
            }
            System.out.println(student);
            cnt += 1;
        }
    }
}