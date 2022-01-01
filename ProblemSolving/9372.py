#9372
from sys import stdin
from collections import deque

n = int(stdin.readline())


def DFS(start):
    global count
    visited[start] = True
    stack = deque()
    stack.append(start)

    while stack:
        v = stack.popleft()
        for i in graph[v]:
            if not visited[i]:
                visited[i] = True
                stack.append(i)
        count += 1


for i in range(n):
    count = 0
    node, edge = map(int, stdin.readline().split())
    graph = [[] for i in range(node + 1)]
    for i in range(edge):
        N, M = map(int, stdin.readline().split())
        graph[N].append(M)
        graph[M].append(N)
    visited = [False] * (node + 1)
    DFS(1)
    print(count - 1)