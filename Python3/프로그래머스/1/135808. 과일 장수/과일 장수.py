import heapq
#3,3,2,2,1,1,1
#4,4,4|,4,4,4|,2,2,2|,2,1,1\4*3*


def solution(k:int, m:int, score:list):
    answer = 0
    scheap=[]
    aplen=len(score)
    boxCnt=aplen//m
    boxList=[]
    for n in  score:
        if n <= k:
            heapq.heappush(scheap,n*-1)
    
    for i in range(boxCnt):
        minSc=k
        for _ in range(m):
            sc=heapq.heappop(scheap)
            sc=sc*-1
            boxList.append(sc)
            if minSc > sc:
                minSc = sc
        res=minSc * m * 1
        answer += res

    return answer