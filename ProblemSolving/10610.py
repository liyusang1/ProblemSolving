# 10610
from sys import stdin

n = list(map(int, stdin.readline().rstrip()))
n.sort(reverse=True)
number = ''
for i in n:
    number += str(i)
number = int(number)

if number % 30 == 0:
    print(number)
else:
    print(-1)
