import java.util.HashMap;
import java.util.Set;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> clothes_table = new HashMap<>();
        for (String[] garmentName : clothes) {
            String type=garmentName[1];
            if (clothes_table.containsKey(type)) {
                int cnt=clothes_table.get(type);
                clothes_table.put(type, cnt+1);
            } else {
                clothes_table.put(type, 1);
            }
        }
        Set<String> clothes_names = clothes_table.keySet();
        for (String key : clothes_names) {
            int n = clothes_table.get(key);
            n += 1;
            answer = answer * n;
        }
        answer -= 1;
        return answer;
    }
}