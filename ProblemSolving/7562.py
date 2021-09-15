#7562
from collections import deque
from sys import stdin

dx = [-1, -2, -2, -1, 1, 2, 2, 1]
dy = [2, 1, -1, -2, -2, -1, 1, 2]


def bfs(x, y, targetX, targetY):
    queue = deque()
    queue.append((x, y))
    graph[x][y] = 0
    while queue:
        X, Y = queue.popleft()
        if X == targetX and Y == targetY:
            print(graph[targetX][targetY])
            return
        for i in range(8):
            nx = X + dx[i]
            ny = Y + dy[i]
            if nx < 0 or ny < 0 or nx >= n or ny >= n:
                continue
            if graph[nx][ny] == 0:
                queue.append((nx, ny))
                graph[nx][ny] = graph[X][Y] + 1


m = int(stdin.readline())
for i in range(m):
    n = int(stdin.readline())
    x, y = map(int, stdin.readline().split())
    targetX, targetY = map(int, stdin.readline().split())
    graph = [[0] * n for i in range(n)]
    bfs(x, y, targetX, targetY)
