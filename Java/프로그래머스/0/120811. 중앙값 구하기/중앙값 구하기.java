import java.util.Arrays;
class Solution {
    public int solution(int[] array) {
        Arrays.sort(array);
        double avrIdx = Math.floor(array.length / 2);
        return array[(int)avrIdx] ;
    }
}