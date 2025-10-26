class Solution {
    public int solution(int[] num_list) {
        int numD = 1;
        int numP = 0;
        for (int i = 0; i < num_list.length; i++) {
            int num = num_list[i];
            numD *= num;
            numP += num;
        }
        double numPow=Math.pow(numP, 2);
        if (numD < numPow) {
            return 1;
        }
        else {
            return 0;
        }


    }
}