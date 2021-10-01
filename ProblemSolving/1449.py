# 1449
from sys import stdin

n, m = map(int, stdin.readline().split())
list1 = list(map(int, stdin.readline().split()))
list1.sort()

start = list1[0]
end = list1[0] + m
count = 1
for i in range(n):
    if not start <= list1[i] < end:
        start = list1[i]
        end = list1[i] + m
        count += 1

print(count)
