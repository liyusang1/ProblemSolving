# 5585
from sys import stdin

money = 1000 - int(stdin.readline())

result = 0
numList = [500, 100, 50, 10, 5, 1]
for i in numList:
    result += money // i
    money %= i

print(result)
