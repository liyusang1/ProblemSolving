# 1475
from sys import stdin

n = list(map(int, stdin.readline().rstrip()))
numberCount = [0] * 9

for i in n:
    if i == 9:
        numberCount[6]+=1
    else:
        numberCount[i] += 1

if numberCount[6] % 2 == 0:
    numberCount[6] /= 2
else:
    numberCount[6] = numberCount[6] // 2 + 1

print(int(max(numberCount)))
