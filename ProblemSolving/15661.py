# 14889, 15661
from sys import stdin
import itertools

minimum = 1e10
n = int(stdin.readline())
overall = [list(map(int, stdin.readline().split())) for _ in range(n)]
numList = [i + 1 for i in range(n)]
visited = [False] * n

leftTeam = []
rightTeam = []


def dfs(count, index):
    global minimum
    if count >= 2:
        rightTeam = list(set(numList) - set(leftTeam))
        leftCom = list(itertools.combinations(leftTeam,2))
        rightCom = list(itertools.combinations(rightTeam,2))

        leftValue = 0
        rightValue = 0
        for x, y in leftCom:
            leftValue += overall[x - 1][y - 1] + overall[y - 1][x - 1]
        for x, y in rightCom:
            rightValue += overall[x - 1][y - 1] + overall[y - 1][x - 1]
        minimum = min(abs(leftValue - rightValue), minimum)

    for i in range(index, n):
        if not visited[i]:
            visited[i] = True
            leftTeam.append(numList[i])
            dfs(count + 1, i + 1)
            leftTeam.pop()
            visited[i] = False


dfs(0, 0)
print(minimum)
