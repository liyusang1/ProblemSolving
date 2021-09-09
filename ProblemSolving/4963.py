# 4963 - dfs with recursion
import sys
from sys import stdin

input = stdin.readline
sys.setrecursionlimit(10000)


def dfs(x, y):
    if x < 0 or y < 0 or x >= m or y >= n or graph[x][y] != 1:
        return
    if graph[x][y] == 1:
        graph[x][y] = 0
        dfs(x + 1, y)
        dfs(x - 1, y)
        dfs(x, y - 1)
        dfs(x, y + 1)
        dfs(x + 1, y + 1)
        dfs(x - 1, y - 1)
        dfs(x - 1, y + 1)
        dfs(x + 1, y - 1)


while True:
    n, m = map(int, input().split())
    if n == 0 and m == 0:
        break
    graph = [list(map(int, input().split())) for _ in range(m)]
    count = 0
    for i in range(m):
        for j in range(n):
            if graph[i][j] == 1:
                count += 1
            dfs(i, j)

    print(count)
