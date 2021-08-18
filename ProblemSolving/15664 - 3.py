# 15664
n, m = map(int, input().split())

numberList = list(map(int, input().split()))
numberList.sort()
result = []
check = []
visited = [False] * n


def dfs(index, count):
    if index == m:
        if not ' '.join(map(str, result)) in check and not ' '.join(map(str, list(reversed(result)))) in check:
            check.append(' '.join(map(str, result)))
            print(' '.join(map(str, result)))
            return
    for i in range(count, n):
        if not visited[i]:
            visited[i] = True
            result.append(numberList[i])
            dfs(index + 1, i + 1)
            result.pop()
            visited[i] = False


dfs(0, 0)
