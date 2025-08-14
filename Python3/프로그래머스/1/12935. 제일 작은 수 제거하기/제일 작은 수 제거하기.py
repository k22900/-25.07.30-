def solution(arr:list):
    
    minNum=min(arr)
    arr.remove(minNum)
    if len(arr)==0:
        arr.append(-1)
    answer = arr
    
    return answer