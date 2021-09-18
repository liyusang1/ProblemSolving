# 1931
from sys import stdin

n = int(stdin.readline())
timeTable = [list(map(int, stdin.readline().split())) for _ in range(n)]

timeTable = sorted(timeTable, key=lambda x: (x[1], x[0]))
end = timeTable[0][1]
count = 1

for i in range(1, len(timeTable)):
    if timeTable[i][0] >= end:
        end = timeTable[i][1]
        count += 1

print(count)
