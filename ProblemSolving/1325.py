# 1325

import sys
from collections import deque

node, edge = map(int, sys.stdin.readline().split())
answer = []

graph = [[] for _ in range(node + 1)]

for _ in range(edge):
    x, y = map(int, sys.stdin.readline().split())
    graph[y].append(x)


def bfs(graph, start, visited):
    count = 0
    queue = deque([start])
    visited[start] = True
    while queue:
        count += 1
        v = queue.popleft()
        for i in graph[v]:
            if not visited[i]:
                visited[i] = True
                queue.append(i)
    return count


maxCount = - 1
for i in range(1, node + 1):
    visited = [False] * (node + 1)
    count = bfs(graph, i, visited)
    if maxCount < count:
        maxCount = count
        answer = [i]
    elif maxCount == count:
        answer.append(i)

for i in answer:
    print(i, end=" ")
