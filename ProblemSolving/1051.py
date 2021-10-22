#1051
from sys import stdin

n, m = map(int, stdin.readline().split())
numberList = [list(map(int, stdin.readline().rstrip())) for _ in range(n)]

check = min(n, m)
answer = 0
for i in range(n):
    for j in range(m):
        for k in range(check):
            if ((i + k) < n) and ((j + k) < m) and (
                    numberList[i][j] == numberList[i][j + k] == numberList[i + k][j] == numberList[i + k][j + k]):
                answer = max(answer, (k + 1) ** 2)
print(answer)
