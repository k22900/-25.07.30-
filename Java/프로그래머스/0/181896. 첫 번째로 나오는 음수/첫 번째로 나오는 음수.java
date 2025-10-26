class Solution {
    public int solution(int[] num_list) {
        for (int i = 0; i < num_list.length; i++) {
            int num = num_list[i];
            if (num<0) {
                return i;
            }
        }
        return -1;
    }
}