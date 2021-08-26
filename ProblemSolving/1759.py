# 1759
from sys import stdin

n, m = map(int, stdin.readline().split())

words = list(stdin.readline().split())
visited = [False] * m
words.sort()
result = []
vowels = ['a', 'e', 'i', 'o', 'u']


def dfs(count, index):
    if count == n:
        wordsCount = len(result)
        vowelsCount = 0
        for i in vowels:
            if i in result:
                wordsCount -= 1
                vowelsCount += 1
        if wordsCount >= 2 and vowelsCount >= 1:
            print("".join(result))

    for i in range(index, m):
        if not visited[i]:
            visited[i] = True
            newWord = words[i]
            result.append(words[i])
            dfs(count + 1, i + 1)
            visited[i] = False
            result.pop()


dfs(0, 0)
