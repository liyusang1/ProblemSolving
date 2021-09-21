# 16940
from sys import stdin
from collections import deque

n = int(stdin.readline())
graph = [[] for _ in range(n + 1)]

for _ in range(n - 1):
    x, y = map(int, stdin.readline().split())
    graph[x].append(y)
    graph[y].append(x)


def bfs(start):
    visited = [False] * (n + 1)
    queue = deque()
    queue.append(start)
    visited[start] = True
    result = [1]
    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if not visited[i]:
                visited[i] = True
                queue.append(i)
                result.append(i)
    return result


result = list(map(int, input().split()))
order = [0] * (n + 1)

for i in range(len(result)):
    order[result[i]] = i

for i in range(1, len(graph)):
    graph[i].sort(key=lambda x: order[x])

if bfs(1) == result:
    print(1)
else:
    print(0)
