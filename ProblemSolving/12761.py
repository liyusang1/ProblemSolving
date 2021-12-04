# 12761

from collections import deque
from sys import stdin


def bfs():
    while q:
        x = q.popleft()
        for i in range(8):
            if i < 6:
                nx = x + d[i]
                if 0 <= nx <= 100000 and visit[nx] == 0:
                    q.append(nx)
                    visit[nx] = 1
                    s[nx] = s[x] + 1
            else:
                nx = x * d[i]
                if 0 <= nx <= 100000 and visit[nx] == 0:
                    q.append(nx)
                    visit[nx] = 1
                    s[nx] = s[x] + 1


a, b, n, m = map(int, stdin.readline().split())
s = [0 for i in range(100001)]
visit = [0 for i in range(100001)]
visit[n] = 1
d = [1, -1, a, -a, b, -b, a, b]
q = deque()
q.append(n)
bfs()
print(s[m])
