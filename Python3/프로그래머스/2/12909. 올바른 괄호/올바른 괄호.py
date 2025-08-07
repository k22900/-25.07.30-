from collections import deque



def solution(s):
    answer = True
    sheet=deque()    
    for v in s:
        if len(sheet) != 0:
            if ")" == v:
                if sheet[-1] == "(":
                    sheet.pop()
                else:
                    sheet.append(v)
            else:
                sheet.append(v)
        else:
            sheet.append(v)
        # print(sheet)  
    if len(sheet) == 0:
        answer = True 
    else:
        answer = False
    return answer