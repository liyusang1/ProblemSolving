# 2606

from collections import deque

node = int(input())
edge = int(input())

graph = [[] for i in range(node + 1)]

for i in range(edge):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)


def bfs(graph, start, visited):
    count = 0
    queue = deque([start])
    visited[start] = True
    while queue:
        v = queue.popleft()
        count += 1
        for i in graph[v]:
            if not visited[i]:
                visited[i] = True
                queue.append(i)
    return count - 1


visited = [False] * (node + 1)
print(bfs(graph, 1, visited))
