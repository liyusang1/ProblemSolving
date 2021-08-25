# 5567

from collections import deque

node = int(input())
edge = int(input())
result = []

graph = [[] for i in range(node + 1)]

for _ in range(edge):
    x, y = map(int, input().split())
    if y not in graph[x]:
        graph[x].append(y)
    if x not in graph[y]:
        graph[y].append(x)

visited = [False] * (node + 1)

number = 0


def bfs(x):
    global number
    queue = deque()
    queue.append(x)
    visited[x] = True
    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True
                check[i] += check[x]+1

check = [0]*(node+1)
bfs(1)
print(check)
print(len(result))
