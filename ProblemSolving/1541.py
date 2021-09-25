#1541
from sys import stdin
a = stdin.readline().split('-')

number = []
for i in a:
    count = 0
    temp = i.split('+')
    for j in temp:
        count += int(j)
    number.append(count)

answer = number[0]
for i in range(1, len(number)):
    answer -= number[i]
print(answer)
