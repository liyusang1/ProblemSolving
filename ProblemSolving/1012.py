# 1012
import sys

sys.setrecursionlimit(100000)

n = int(sys.stdin.readline())
answer = []


def dfs(x, y):
    if x < 0 or y < 0 or x >= N or y >= M:
        return False
    if list[x][y] == 1:
        list[x][y] = 0
        dfs(x - 1, y)
        dfs(x, y - 1)
        dfs(x + 1, y)
        dfs(x, y + 1)
        return True
    return False


for i in range(n):
    N, M, k = map(int, sys.stdin.readline().split())
    list = [[0] * M for _ in range(N)]
    for _ in range(k):
        x, y = map(int, sys.stdin.readline().split())
        list[x][y] = 1

    result = 0
    for i in range(N):
        for j in range(M):
            if dfs(i, j) == True:
                result += 1
    answer.append(result)

for i in answer:
    print(i)
