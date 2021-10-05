from sys import stdin
from collections import deque

n, m = map(int, stdin.readline().split())

# *** 무조건 값이 증가하기 때문에 사이클이 생기지 않아 visited가 필요없는 것이 Point!! ***
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
