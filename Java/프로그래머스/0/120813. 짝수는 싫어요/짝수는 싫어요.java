class Solution {
    public int[] solution(int n) {
        double len = Math.ceil((double) n / 2);
        int[] answer = new int[(int) len];
        int cnt = 0;
        for (int i = 1; i <= n; i += 2) {
            answer[cnt] = i;
            cnt += 1;
        }
        return answer;
    }
}