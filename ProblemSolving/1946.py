# 1946
from sys import stdin

n = int(stdin.readline())
for _ in range(n):
    count = int(stdin.readline())
    person = []
    for _ in range(count):
        x, y = map(int, stdin.readline().split())
        person.append([x, y])
    person.sort(key=lambda x: x[0])

    minNum = person[0][1]
    result = 1
    for i in range(1, count):
        if person[i][1] < minNum:
            minNum = person[i][1]
            result += 1
    print(result)
