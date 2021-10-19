# 10971

from itertools import permutations
import sys
m = 999999999

n = int(sys.stdin.readline())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

def solution(list):
    sum = 0
    for j in range(n - 1):
        if graph[list[j]][list[j + 1]] == 0:
            return False
        else:
            sum += graph[list[j]][list[j + 1]]

    if graph[list[-1]][list[0]] == 0:
        return False
    else:
        sum += graph[list[-1]][list[0]]

    return sum

for i in permutations([i for i in range(n)]):
    result = solution(i)
    if result != False:
        if m > result:
            m = result

print(m)
