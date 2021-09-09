#1707
import collections
import sys

sys.setrecursionlimit(10000)
input = sys.stdin.readline

n = int(input())

for _ in range(n):
    vertex, edge = map(int, input().split())
    graph = [[] for _ in range(vertex + 1)]

    for _ in range(edge):
        x, y = map(int, input().split())
        graph[x].append(y)
        graph[y].append(x)

    visited = [False] * (vertex + 1)
    group = 1
    q = collections.deque()
    result = True
    for i in range(1, vertex + 1):
        if visited[i] == 0:
            q.append(i)
            visited[i] = group
        while q:
            v = q.popleft()
            for w in graph[v]:
                if visited[w] == 0:
                    q.append(w)
                    visited[w] = -1 * visited[v]
                elif visited[v] == visited[w]:
                    result = False
    if result:
        print('YES')
    else:
        print('NO')
