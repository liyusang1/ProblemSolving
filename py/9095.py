# 9095

answerList = [0, 1, 2, 4]

def solution(n):
    if n <= 3:
        return answerList[n]
    else:
        for i in range(3, n):
            answerList.append(answerList[i] + answerList[i - 1] + answerList[i - 2])

solution(11)

n = int(input())
result = []
for _ in range(n):
    n = int(input())
    result.append(answerList[n])

for _ in result:
    print(_)
