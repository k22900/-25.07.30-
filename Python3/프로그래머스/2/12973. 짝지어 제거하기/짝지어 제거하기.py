def solution(s):
    answer = -1
    sheet=[]
    for v in s:
        if len(sheet) != 0:
            if sheet[-1] == v:
                sheet.pop()
            else:
                sheet.append(v)
        else:
            sheet.append(v)
        # print(sheet)
    if len(sheet) == 0:   
        answer = 1
    else:
        answer = 0

    return answer