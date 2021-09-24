#13458
from sys import stdin

n = int(stdin.readline())
student = list(map(int, stdin.readline().split()))
check1, check2 = map(int, stdin.readline().split())

result = 0
for i in student:
    if i > check1:
        result += (i - check1) // check2 + 1
        if (i - check1) % check2 != 0:
            result += 1
    else:
        result += 1

print(result)
