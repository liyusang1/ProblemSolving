# 12927
from sys import stdin

result = 0
switch = list(stdin.readline().rstrip())
for i in range(len(switch)):
    if switch[i] == 'Y':
        for j in range(i, len(switch), i + 1):
            if switch[j] == 'Y':
                switch[j] = 'N'
            else:
                switch[j] = 'Y'
        result += 1

print(result)
