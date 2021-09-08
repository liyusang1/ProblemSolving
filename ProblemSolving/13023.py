# 13023

from sys import stdin
from collections import deque
import sys

sys.setrecursionlimit(10000)

node, edge = map(int, stdin.readline().split())
graph = [[] for _ in range(node)]

for _ in range(edge):
    x, y = map(int, stdin.readline().split())
    graph[x].append(y)
    graph[y].append(x)

resultCheck = 0


def dfs(start, depth):
    global resultCheck
    if depth >= 4:
        resultCheck = 1
        return
    visited[start] = True

    for i in graph[start]:
        if not visited[i]:
            visited[i] = True
            dfs(i, depth + 1)
            visited[i] = False


for i in range(node):
    visited = [False] * node
    dfs(i, 0)
    if resultCheck == 1:
        break

print(resultCheck)
