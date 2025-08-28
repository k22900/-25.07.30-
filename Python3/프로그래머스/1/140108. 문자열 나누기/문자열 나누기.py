def solution(s):
    answer = 0
    
    sCnt=0
    oCnt=0
    
    x=None
    for w in s:
        if x is None:
            x=w
            sCnt+=1
        else:
            if x==w:
                sCnt+=1
            else:
                oCnt+=1
        if sCnt==oCnt:
            x=None
            answer+=1
            sCnt=oCnt=0
    if x is None:
        return answer
    else:
        answer+=1
        return answer
