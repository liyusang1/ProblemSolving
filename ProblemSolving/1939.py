# 1939

from collections import deque

start = 100000
end = 1

node, edge = map(int, input().split())

graph = [[] for _ in range(node + 1)]

for _ in range(edge):
    x, y, weight = map(int, input().split())
    graph[x].append([y, weight])
    graph[y].append([x, weight])
    start = min(start, weight)
    end = max(end, weight)


def bfs(graph, v, weight):
    visited = [False] * (node + 1)
    visited[v] = True
    queue = deque([v])
    while queue:
        v = queue.popleft()
        for i, w in graph[v]:
            if w >= weight and not visited[i]:
                visited[i] = True
                queue.append(i)
    return visited[endNode]


startNode, endNode = map(int, input().split())

result = 1
while start <= end:
    mid = (start + end) // 2
    if bfs(graph, startNode, mid) == True:
        result = mid
        start = mid + 1
    else:
        end = mid - 1

print(result)
