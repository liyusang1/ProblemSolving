# 16929

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def DFS(x, y):
    global answer
    visited[x][y] = 1
    for d in range(4):
        X = x + dx[d]
        Y = y + dy[d]
        if 0 <= X < N and 0 <= Y < M:
            if board[X][Y] == board[x][y]:
                if visited[X][Y] == 0:
                    history.append([X, Y])
                    DFS(X, Y)
                    history.pop()
                else:
                    if X == history[-2][0] and Y == history[-2][1]:  # 바로 전에 방문한 경우
                        pass
                    else:  # 바로 전은 아닌데 언젠가 방문한 적이 있는 경우 -> 사이클을 형성하게 됨
                        answer = 'Yes'
                        return
        if answer == 'Yes':
            return


N, M = map(int, input().split())
board = []
visited = [[0] * M for _ in range(N)]
for _ in range(N):
    board.append(input())

answer = 'No'
for i in range(N):
    for j in range(M):
        if visited[i][j] == 0:
            history = [[i, j]]
            DFS(i, j)
        if answer == 'Yes':
            break
    if answer == 'Yes':
        break

print(answer)
