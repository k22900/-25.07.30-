def counter(l):
    listmap={}
    for v in l:
        num=listmap.get(v,0)
        listmap[v]=num+1
    return listmap

def solution(participant, completion):
    answer=""
    participantMap=counter(participant)
    completMap=counter(completion)
    
    for key,val in completMap.items():
        num=participantMap.get(key)
        participantMap[key]=num-val
        
    
    for key,val in participantMap.items():
        if val > 0: 
            answer = key
            print(answer)
    
    return answer