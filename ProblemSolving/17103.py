# 17103

from sys import stdin

maxNum = 1000000
isPrime = [True for i in range(maxNum)]
isPrime[1] = False

# 에라토스테네스의 체
for i in range(2, int(maxNum ** 0.5) + 1):
    if isPrime[i]:
        for j in range(i * 2, maxNum, i):
            isPrime[j] = False

n = int(stdin.readline())
for _ in range(n):
    m = int(stdin.readline())

    count = 0
    for i in range(3, (m // 2) + 1):
        if isPrime[i] and isPrime[m - i]:
            count += 1
    print(count)
