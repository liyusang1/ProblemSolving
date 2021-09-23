# 16964
from sys import stdin
from collections import deque

n = int(stdin.readline())
graph = [[] for _ in range(n + 1)]

for i in range(n - 1):
    x, y = map(int, stdin.readline().rstrip().split())
    graph[x].append(y)
    graph[y].append(x)

visited = [False] * (n + 1)


def dfs(start):
    stack = deque()
    stack.append(start)
    visited[start] = True
    result = []
    while stack:
        v = stack.pop()
        result.append(v)
        for i in graph[v]:
            if not visited[i]:
                visited[i] = True
                stack.append(i)
    return result


answer = list(map(int, input().split()))
order = [0] * (n + 1)

for i in range(len(answer)):
    order[answer[i]] = i

for i in range(1, len(graph)):
    graph[i].sort(key=lambda x: order[x], reverse=True)

if dfs(1) == answer:
    print(1)
else:
    print(0)
