# 12845
from sys import stdin

n = int(stdin.readline())
level = list(map(int, stdin.readline().split()))
level.sort(reverse=True)
pivot = level[0]
result = 0

for i in range(1, len(level)):
    result += level[i] + pivot
print(result)
