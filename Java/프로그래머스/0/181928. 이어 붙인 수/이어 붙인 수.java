class Solution {
    public int solution(int[] num_list) {
        String singleNum = "";
        String dubleNum = "";

        for (int i = 0; i < num_list.length; i++) {
            int num = num_list[i];
            if (num % 2 == 0) {
                dubleNum += num;
            }
            if (num % 2 == 1) {
                singleNum += num;
            }

        }
        int sNum = Integer.parseInt(singleNum);
        int dNum = Integer.parseInt(dubleNum);

        int answer = sNum + dNum;
        return answer;
    }
}
