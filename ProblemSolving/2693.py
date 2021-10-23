#2693
from sys import stdin

n = int(stdin.readline())

for _ in range(n):
    numbers = list(map(int,stdin.readline().split()))
    numbers.sort(reverse=True)
    print(numbers[2])