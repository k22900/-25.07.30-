from collections import Counter

def solution(participant, completion):
    
    partCnt=Counter(participant)
    completCnt=Counter(completion)
    
    result=partCnt - completCnt
    for key,val in result.items():
        answer=key
    print(answer)
    
    return answer