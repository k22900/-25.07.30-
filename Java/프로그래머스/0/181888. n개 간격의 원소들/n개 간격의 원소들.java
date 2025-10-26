class Solution {
    public int[] solution(int[] num_list, int n) {
        double len = Math.ceil(num_list.length / (double)n);
        int[] answer = new int[(int) len];
        int cnt = 0;
        for (int i = 0; i < num_list.length; i += n) {
            int num=num_list[i];
            answer[cnt]+= num;
            cnt += 1;
        }
        return answer;
    }
}