# 11399
from sys import stdin


def result(list):
    result = [0 for _ in range(len(list))]
    result[0] = list[0]
    if len(list) > 1:
        result[1] = list[0] + list[1]
        for i in range(2, len(list)):
            result[i] = result[i - 1] + list[i]
    return sum(result)


n = stdin.readline()
myList = sorted(list(map(int, stdin.readline().split())))
print(result(myList))
