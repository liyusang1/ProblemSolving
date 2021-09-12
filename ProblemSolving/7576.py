# 7576
from sys import stdin
from collections import deque

n, m = map(int, stdin.readline().split())
graph = [list(map(int, stdin.readline().split())) for _ in range(m)]
visited = [[False] * n for _ in range(m)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs():
    while queue:
        x, y = queue.popleft()
        if graph[x][y] >= 1 and not visited[x][y]:
            visited[x][y] = True
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if nx < 0 or ny < 0 or nx >= m or ny >= n:
                    continue
                if graph[nx][ny] == -1:
                    continue
                if graph[nx][ny] == 0:
                    graph[nx][ny] = graph[x][y] + 1
                    queue.append((nx, ny))


queue = deque()
for i in range(m):
    for j in range(n):
        if graph[i][j] == 1:
            queue.append([i, j])
bfs()

maxNum = -999
for i in graph:
    for j in i:
        if j == 0:
            print(-1)
            exit(0)
        maxNum = max(j, maxNum)

print(maxNum - 1)
