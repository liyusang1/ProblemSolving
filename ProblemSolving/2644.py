# 2644
from sys import stdin
from collections import deque

n = int(stdin.readline())
first, end = map(int, stdin.readline().split())
graph = [[] for i in range(n + 1)]

count = int(stdin.readline())
for i in range(count):
    x, y = map(int, stdin.readline().split())
    graph[x].append(y)
    graph[y].append(x)

for i in graph:
    i.sort(reverse=True)

result = [0] * (n + 1)
visited = [False] * (n + 1)
count = 0


def dfs(start):
    global count
    stack = deque()
    stack.append(start)
    visited[start] = True
    while stack:
        v = stack.pop()
        if v == end:
            print(result[v])
            print(exit())
        for i in graph[v]:
            if not visited[i]:
                visited[i] = True
                stack.append(i)
                result[i] = result[v] + 1


dfs(first)
print(-1)
