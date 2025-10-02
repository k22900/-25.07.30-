def solution(arr1, arr2):
    arrLen=len(arr1)
    answer = []
    for i in range(arrLen):
        res=[]
        for n1,n2 in zip(arr1[i],arr2[i]):
            res.append(n1+n2)
        answer.append(res)
            
    return answer