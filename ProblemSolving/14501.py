# 14501

import sys

n = int(sys.stdin.readline())

timeTable = [list(map(int, sys.stdin.readline().split())) for i in range(n)]
dp = [0 for i in range(n + 1)]

for i in range(n - 1, -1, -1):
    if i + timeTable[i][0] > n:
        dp[i] = dp[i + 1]
    else:
        dp[i] = max(timeTable[i][1] + dp[i + timeTable[i][0]], dp[i + 1])

# n+1번째 날 기준 수익(dp)와 n번째 날 수익 + Tn 만큼 지난 후 수익(dp)중 큰 값을 골라야 함.
print(dp[0])
