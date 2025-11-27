import java.util.HashSet;
import java.util.Set;
class Solution {
    public int solution(int[] nums) {
    int answer = 0;
    Set<Integer> type = new HashSet<>();
    for (int num : nums) {
        type.add(num);
    }
    int len = nums.length;
    answer = Math.min(len/2, type.size());
    return answer;
}
}