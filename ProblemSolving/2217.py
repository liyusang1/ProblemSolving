# 2217
from sys import stdin

n = int(stdin.readline())
rope = []
for _ in range(n):
    rope.append(int(stdin.readline()))
rope.sort(reverse=True)

maxNum = -9999
for i in range(len(rope)):
    maxNum = max(rope[i] * (i + 1), maxNum)

print(maxNum)
