#15657

n, m = map(int, input().split())

numberList = list(map(int, input().split()))
numberList.sort()
result = []
visited = [False] * n

def dfs(index,count):
    if index == m:
        print(' '.join(map(str, result)))
        return
    for i in range(count,n):
        result.append(numberList[i])
        dfs(index + 1,i)
        result.pop()

dfs(0,0)
