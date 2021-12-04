# 3060
from sys import stdin

n = int(stdin.readline())

for i in range(n):
    result = 1
    value = int(stdin.readline())
    food = sum(list(map(int, stdin.readline().split())))
    while value >= food:
        result += 1
        food *= 4
    print(result)
