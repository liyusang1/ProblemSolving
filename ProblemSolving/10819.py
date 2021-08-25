#10819
import itertools

n = int(input())
max = 0

numberList = list(map(int,input().split()))
perList =  list(itertools.permutations(numberList,n))

for i in perList:
    sum = 0
    for j in range(len(i)-1):
        sum += abs(i[j]-i[j+1])
    if max < sum:
        max = sum

print(max)