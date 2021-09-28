#2012

from sys import stdin

n = int(stdin.readline())

list1 = []
list2 = [i+1 for i in range(n)]
for _ in range(n):
    list1.append(int(stdin.readline()))
list1.sort()

result = 0
for i in range(n):
    result += abs(list2[i]-list1[i])
print(result)