# 1476

n = list(map(int, input().split()))

number = [1, 1, 1]
result = 1

while number != n:
    number[0] += 1
    number[1] += 1
    number[2] += 1
    result += 1

    if number[0] > 15:
        number[0] -= 15
    if number[1] > 28:
        number[1] -= 28
    if number[2] > 19:
        number[2] -= 19

print(result)