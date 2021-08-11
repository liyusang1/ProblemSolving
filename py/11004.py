# 11004

import sys

count, index = map(int, sys.stdin.readline().split())

result = list(map(int, sys.stdin.readline().split()))
result.sort()

print(result[index - 1])
