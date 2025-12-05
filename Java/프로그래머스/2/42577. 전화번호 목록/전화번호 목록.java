import java.util.HashSet;
import java.util.Set;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> comp = new HashSet<>();
        for (String num : phone_book) {
            comp.add(num);
        }
        for (String phone_num : phone_book) {
            for (int n = 1; n < phone_num.length(); n++) {
                String prefix=phone_num.substring(0,n);
                if (comp.contains(prefix)) {
                    return false;
                }
            }
        }
        return answer;
    }
}