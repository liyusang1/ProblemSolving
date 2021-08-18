# 15656

n, m = map(int, input().split())

numberList = list(map(int, input().split()))
numberList.sort()
result = []
visited = [False] * n


def dfs(index):
    if index == m:
        print(' '.join(map(str, result)))
        return
    for i in range(n):
        result.append(numberList[i])
        dfs(index + 1)
        result.pop()


dfs(0)
