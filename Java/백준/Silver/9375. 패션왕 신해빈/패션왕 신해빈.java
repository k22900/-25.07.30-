import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.valueOf(br.readLine());
        for (int i = 0; i < num; i++) {
            int n = Integer.valueOf(br.readLine());
            Map<String, Integer> clothingTypes = new HashMap<>();
            for (int l = 0; l < n; l++) {
                StringTokenizer cloth = new StringTokenizer(br.readLine());
                cloth.nextToken();
                String clothType=cloth.nextToken();
                int cnt = clothingTypes.getOrDefault(clothType, 0);
                cnt += 1;
                clothingTypes.put(clothType, cnt);

            }
            int result = 1;
            for (int clothCnt : clothingTypes.values()) {
                clothCnt += 1;
                result *= clothCnt;
            }
            result -= 1;
            System.out.println(result);

        }
    }
}