class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            if (num == n) {
                answer += 1;
            }
        }
        return answer;
    }
}