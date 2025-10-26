class Solution {
    public int solution(int a, int b) {
        String resP = String.valueOf(a) + b;
        int resD = 2 * a * b;
        int answer = Math.max(Integer.parseInt(resP) ,resD);
        return answer;
    }
}