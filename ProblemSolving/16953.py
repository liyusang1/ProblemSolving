from sys import stdin
from collections import deque

n, m = map(int, stdin.readline().split())


def BFS():
    queue = deque()
    queue.append([n, 1])
    while queue:
        currentValue, count = queue.popleft()
        if currentValue == m:
            return count
        for temp in (currentValue * 2, (currentValue * 10) + 1):
            if temp <= m:
                queue.append([temp, count + 1])
    return -1


print(BFS())
