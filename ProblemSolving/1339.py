# 1339
# 핵심 point
# 글자 값의 위치에 따라 딕셔너리 값을 지정해 주는 것이 핵심
# ABCD -> dict[A]=1000, dict[B]=100, dict[C]=10 ....
# 이 때 중복된 알파벳이 나온경우 딕셔너리에 값을 추가해주면 됨
# AE -> dict[A]=1000+10 , dict[E]=1
# 그 후 딕셔너리를 내림차순으로 정렬 후 9~1로 곱해 줌
from sys import stdin

n = int(stdin.readline())
wordList = []
wordDictionary = dict()

for _ in range(n):
    wordList.append(list(stdin.readline().rstrip()))

for i in range(len(wordList)):
    for j in range(len(wordList[i])):
        if not wordList[i][j] in wordDictionary:
            wordDictionary[wordList[i][j]] = 10 ** (len(wordList[i]) - j - 1)
        else:
            wordDictionary[wordList[i][j]] += 10 ** (len(wordList[i]) - j - 1)

wordDictionary = sorted(wordDictionary.values(), reverse=True)
result = 0
temp = 9
for i in wordDictionary:
    result += i * temp
    temp -= 1
print(result)