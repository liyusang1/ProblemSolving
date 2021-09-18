# 1080

from sys import stdin


def convert(x, y):
    for i in range(x, x + 3):
        for j in range(y, y + 3):
            matrix1[i][j] = 1 - matrix1[i][j]


n, m = map(int, stdin.readline().split())
matrix1 = [list(map(int, stdin.readline().rstrip())) for _ in range(n)]
matrix2 = [list(map(int, stdin.readline().rstrip())) for _ in range(n)]

count = 0
for i in range(n - 2):
    for j in range(m - 2):
        if matrix1[i][j] != matrix2[i][j]:
            convert(i, j)
            count += 1

check = True
for i in range(n):
    for j in range(m):
        if matrix1[i][j] != matrix2[i][j]:
            check = False
            break

if not check:
    print(-1)
else:
    print(count)
