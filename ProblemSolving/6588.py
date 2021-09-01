# 6588
from sys import stdin

# 에라토스테네스의 체
maxNum = 1000000
isPrime = [True for _ in range(maxNum)]
for i in range(2, int((maxNum) ** 0.5) + 1):
    if isPrime[i]:
        for k in range(i + i, maxNum, i):
            isPrime[k] = False

while True:
    n = int(stdin.readline())
    if n == 0:
        break

    for i in range(3, n):
        if isPrime[i] and isPrime[n - i]:
            print("{} = {} + {}".format(n, i, n - i))
            break
