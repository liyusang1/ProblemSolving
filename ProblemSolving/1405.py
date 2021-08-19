# 1405
visited = [[0] * 30 for _ in range(30)]
visited[15][15] = 1

count, E, W, S, N = map(int, input().split())
probability = [N * 0.01, E * 0.01, S * 0.01, W * 0.01]
dx, dy = [-1, 0, 1, 0], [0, 1, 0, -1]


def dfs(x, y, curCount, prob):
    global answer

    if curCount == count:
        answer += prob
        return

    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]
        if not visited[nx][ny]:
            visited[nx][ny] = 1
            dfs(nx, ny, curCount + 1, prob * probability[i])
            visited[nx][ny] = 0


answer = 0
dfs(15, 15, 0, 1)
print(answer)
