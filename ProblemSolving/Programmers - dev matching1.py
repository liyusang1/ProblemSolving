from sys import stdin

def solution(lottos, winNums):
    count = 0
    zeroCount = 0

    for i in winNums:
        if i in lottos:
            count += 1

    for i in lottos:
        if i == 0:
            zeroCount += 1

    bestCase = 7 - (count + zeroCount)
    if bestCase >= 7:
        bestCase = 6

    worstCase = 7 - (count)
    if worstCase >= 7:
        worstCase = 6

    answer = [bestCase, worstCase]
    return answer
