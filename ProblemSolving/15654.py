# 15654

n, m = map(int, input().split())

numberList = list(map(int, input().split()))
numberList.sort()
result = []
visited = [False] * n


def dfs(index, n):
    if index == m:
        print(" ".join(map(str, result)))
        return
    for i in range(n):
        if not visited[i]:
            visited[i] = True
            result.append(numberList[i])
            dfs(index + 1, n)
            result.pop()
            visited[i] = False


dfs(0, n)
