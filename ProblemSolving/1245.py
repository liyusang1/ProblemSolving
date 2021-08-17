# 1245

import sys

sys.setrecursionlimit(10000)

n, m = map(int, sys.stdin.readline().split())

graph = []

for _ in range(n):
    graph.append(list(map(int, sys.stdin.readline().split())))


def dfs(x, y):
    if x < 0 or y < 0 or x >= n or y >= m:
        return False
    if graph[x][y] > 0:
        graph[x][y] = 0
        dfs(x + 1, y)
        dfs(x, y + 1)
        dfs(x - 1, y)
        dfs(x, y - 1)
        return True
    return False


count = 0
for i in range(n):
    for j in range(m):
        if dfs(i, j) == True:
            count += 1

print(count)
