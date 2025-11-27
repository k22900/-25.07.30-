import java.util.HashMap;

import java.util.Set;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
    HashMap<String,Integer> pMap = new HashMap<>();
    HashMap<String,Integer> completionCnt = new HashMap<>();

    for (int i = 0; i < participant.length; i++) {
        String w = participant[i];
        int cnt = 1;
        if (pMap.containsKey(w)) {
            cnt = pMap.get(w);
            pMap.put(w, cnt + 1);
        } else {
            pMap.put(w, cnt);
        }
    }


    for (int i = 0; i < completion.length; i++) {
        String w = completion[i];
        int cnt = pMap.get(w);
        pMap.put(w, cnt - 1);
    }
    Set<String> keys =pMap.keySet();
    for (String k : keys) {
        int val =pMap.get(k);
        if (val == 1) {
            answer = k;
            break;
        }
    }
    return answer;
    }
}