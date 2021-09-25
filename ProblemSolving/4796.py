# 4796
from sys import stdin

count = 1
while True:
    result = 0
    L, P, V = map(int, stdin.readline().split())
    if L == 0 and P == 0 and V == 0:
        exit()
    result += L * (V // P)
    temp = V % P
    if temp <= P and temp <= L: #반례1
        result+=temp
    elif temp > L : #반례2
        result += L
    print("Case {}: {}".format(count, result))
    count += 1
