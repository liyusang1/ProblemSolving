# 17087
from sys import stdin
from math import gcd


def multipleGcd(list):
    if len(list) == 1:
        return list[0]
    temp = gcd(list[0], list[1])
    for i in range(3, len(list)):
        temp = gcd(temp, list[i])
    return temp


count, position = map(int, stdin.readline().split())
sisPosition = list(map(int, stdin.readline().split()))
result = []

for i in sisPosition:
    result.append(abs(position - i))

print(multipleGcd(result))
