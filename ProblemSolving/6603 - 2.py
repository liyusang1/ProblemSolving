def dfs(count, index):
    if count == 6:
        print(" ".join(map(str, result)))

    for i in range(index, len(numberList)):
        if not visited[i]:
            visited[i] = True
            result.append(numberList[i])
            dfs(count + 1, i + 1)
            result.pop()
            visited[i] = False


while True:
    numberList = list(map(int, input().split()))
    if numberList[0] == 0:
        break

    numberList = numberList[1:]
    visited = [False] * len(numberList)
    result = []
    dfs(0, 0)
    print()
