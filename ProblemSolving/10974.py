# 10974
n = int(input())
numberList = [i for i in range(1, n + 1)]
result = []
visited = [False] * n

def dfs(count):
    if count == n:
        print(" ".join(map(str, result)))

    for i in range(n):
        if not visited[i]:
            visited[i] = True
            result.append(numberList[i])
            dfs(count + 1)
            visited[i] = False
            result.pop()
dfs(0)

#import itertools

#n = int(input())

#list1 = list(itertools.permutations([i+1 for i in range(n)],n))

#for i in list1:
#    print(" ".join(map(str,i)))

