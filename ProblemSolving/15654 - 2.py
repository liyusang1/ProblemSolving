#15654 itertool 풀이
import itertools

n, m = map(int, input().split())

numberList = list(map(int, input().split()))
numberList.sort()
answer = list(itertools.permutations(numberList,m))

for i in answer:
    print(" ".join(map(str,i)))