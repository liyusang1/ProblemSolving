# 1074

import sys

def solution(N, x, y):
    global result
    if x == r and y == c:
        print(int(result))
        exit(0)

    if N == 1:
        result += 1
        return

    if not (x <= r < x + N and y <= c < y + N):
        result += N * N
        return
    solution(N / 2, x, y)
    solution(N / 2, x, y + N / 2)
    solution(N / 2, x + N / 2, y)
    solution(N / 2, x + N / 2, y + N / 2)

result = 0
N, r, c = map(int, sys.stdin.readline().split())
solution(2 ** N, 0, 0)
