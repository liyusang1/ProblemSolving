# 2630
from sys import stdin

N = int(stdin.readline())
graph = [list(map(int, stdin.readline().split())) for _ in range(N)]

blue = 0  # 1
white = 0  # 0
result = 0


def solution(x, y, n):
    global blue, white
    temp = graph[x][y]
    for i in range(x, x + n):
        for j in range(y, y + n):
            if temp != graph[i][j]:
                solution(x, y, n // 2)
                solution(x + (n // 2), y, n // 2)
                solution(x, y + (n // 2), n // 2)
                solution(x + (n // 2), y + (n // 2), n // 2)
                return

    if temp == 0:
        white += 1
    else:
        blue += 1


solution(0, 0, N)
print(white)
print(blue)
