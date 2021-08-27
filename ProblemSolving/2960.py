# 2960

n, m = map(int, input().split())

numList = [i for i in range(2, n + 1)]

answer = []
while numList:
    result = []
    minNum = numList[0]
    result.append(minNum)
    for i in range(1, len(numList)):
        if numList[i] % minNum == 0:
            result.append(numList[i])

    for i in result:
        numList.remove(i)
    answer.extend(result)

print(answer[m - 1])
