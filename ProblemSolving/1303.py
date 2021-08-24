# 1303
import sys

sys.setrecursionlimit(10000)

n, m = map(int, input().split())

graph = [list(input()) for _ in range(m)]


def dfs(x, y, word):
    global count
    if x < 0 or y < 0 or x >= m or y >= n:
        return False
    if graph[x][y] == word:
        graph[x][y] = 0
        count += 1
        dfs(x - 1, y, word)
        dfs(x + 1, y, word)
        dfs(x, y - 1, word)
        dfs(x, y + 1, word)
        return True
    return False


count = 0
wCount = 0
bCount = 0
for i in range(m):
    for j in range(n):
        if dfs(i, j, 'W'):
            wCount += count ** 2
            count = 0

count = 0
for i in range(m):
    for j in range(n):
        if dfs(i, j, 'B'):
            bCount += count ** 2
            count = 0

print(wCount, bCount, end=" ")
