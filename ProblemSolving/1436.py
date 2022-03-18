# 1436

from sys import stdin

n = int(stdin.readline())

answer = 666

while True:
    if '666' in str(answer):
        n -= 1
        if n == 0:
            break

    answer += 1

print(answer)
