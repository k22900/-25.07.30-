import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < arr.length; i++ ) {
            int n = arr[i];
            if (n % divisor == 0) {
                res.add(n);
            }
        }
        int len = res.size();
        int[] answer = new int[len];
        if (len > 0) {


            for (int l = 0; l < len; l++) {
                int num = res.get(l);
                answer[l] = num;
            }
            Arrays.sort(answer);
        } 
        else{
            int[] n = {-1};
            return n;
        }
        return answer;
    }
}