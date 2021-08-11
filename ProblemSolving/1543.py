# 1543

import sys

string = input()
check = input()

index = 0
result = 0
while len(string) - index >= len(check):
    if string[index:index + len(check)] == check:
        index += len(check)
        result += 1
    else:
        index += 1

print(result)
