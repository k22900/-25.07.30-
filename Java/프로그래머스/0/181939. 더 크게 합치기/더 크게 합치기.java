class Solution {
    public int solution(int a, int b) {
        String n1=String.valueOf(a);
        String n2=String.valueOf(b);
        String fNum = n1 + n2;
        String bNum = n2 + n1;
        int res=Math.max(Integer.parseInt(fNum), Integer.parseInt(bNum));
        int answer = res;
        return answer;
    }
}