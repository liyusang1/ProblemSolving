# 4963 - bfs
import sys
from sys import stdin
from collections import deque

input = stdin.readline

dx = [0, -1, 0, 1, -1, 1, -1, 1]
dy = [-1, 0, 1, 0, -1, 1, 1, -1]


def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    graph[x][y] = 0
    while queue:
        x, y = queue.popleft()
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= m or ny >= n:
                continue
            if graph[nx][ny] == 1:
                graph[nx][ny] = 0
                queue.append((nx, ny))


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
                bfs(i, j)

    print(count)
