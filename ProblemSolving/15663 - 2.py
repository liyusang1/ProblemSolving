# 15663 itertool 풀이
import itertools

n, m = map(int, input().split())

numberList = list(map(int, input().split()))
numberList.sort()
answer = list(itertools.permutations(numberList, m))

answer = sorted(list(set(answer)))  # set 자료구조를 이용한 중복 제거

for i in answer:
    print(" ".join(map(str, i)))
