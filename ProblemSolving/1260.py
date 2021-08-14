# 1260
from collections import deque

N, M, V = map(int, input().split())

graph = [[] for i in range(N + 1)]

for i in range(M):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

for i in graph:
    i.sort()


def dfs(graph, V, visited):
    visited[V] = True
    print(V, end=" ")
    for i in graph[V]:
        if not visited[i]:
            dfs(graph, i, visited)


def bfs(graph, start, visited):
    queue = deque([start])
    visited[start] = True
    while queue:
        v = queue.popleft()
        print(v, end=" ")
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True


visited = [False] * (N + 1)
dfs(graph, V, visited)
print()
visited = [False] * (N + 1)
bfs(graph, V, visited)
