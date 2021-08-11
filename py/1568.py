# 1568

n = int(input())

count = 0
number = 1

while n != 0:
    if n - number < 0:
        number = 1
    n -= number
    count += 1
    number += 1

print(count)
