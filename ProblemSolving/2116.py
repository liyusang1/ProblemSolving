maxnum = 0
n = int(input())

numberList = [list(map(int, input().split())) for _ in range(n)]
rotate = {0: 5, 1: 3, 2: 4, 3: 1, 4: 2, 5: 0}

for i in range(6):
    result = []
    number = [1, 2, 3, 4, 5, 6]
    number.remove(numberList[0][i])
    next = numberList[0][rotate[i]]
    number.remove(next)
    result.append(max(number))
    for j in range(1, n):
        number = [1, 2, 3, 4, 5, 6]
        number.remove(next)
        next = numberList[j][rotate[numberList[j].index(next)]]
        number.remove(next)
        result.append(max(number))
    result = sum(result)
    if maxnum < result:
        maxnum = result

print(maxnum)

