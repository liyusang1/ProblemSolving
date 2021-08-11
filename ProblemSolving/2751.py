# 2751

import sys

number = int(sys.stdin.readline())
result = []

for _ in range(number):
    result.append(int(sys.stdin.readline()))

result = sorted(list(set(result)))

for i in result:
    print(i)
