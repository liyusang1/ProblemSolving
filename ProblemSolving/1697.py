# 1697

from collections import deque

MAX = 100001
n, m = map(int, input().split())
array = [0] * MAX


def bfs():
    queue = deque([n])
    while queue:
        now = queue.popleft()
        if now == m:
            return array[now]
        for next in (now + 1, now - 1, now * 2):
            if 0 <= next < MAX and not array[next]:
                array[next] = array[now] + 1
                queue.append(next)


print(bfs())
