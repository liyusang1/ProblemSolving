# 1744
from sys import stdin

n = int(stdin.readline())

minusNumber = []
plusNumber = []
zero = []

for _ in range(n):
    number = int(stdin.readline())
    if number < 0:
        minusNumber.append(number)
    elif number == 0:
        zero.append(number)
    else:
        plusNumber.append(number)

minusNumber.sort(reverse=True)
plusNumber.sort()

result = 0
if minusNumber:
    if len(minusNumber) % 2 == 0:
        for i in range(0, len(minusNumber) - 1, 2):
            result += minusNumber[i] * minusNumber[i + 1]
    else:
        temp = minusNumber.pop(0)
        result += temp
        for i in range(0, len(minusNumber) - 1, 2):
            result += minusNumber[i] * minusNumber[i + 1]

        # ** 첫번째 포인트 0이 있으면 이에 따른 처리를 해주어야 한다 **
        if zero:
            result += temp * -1

if plusNumber:
    # ** 두번째 포인트 -> 값이 1이면 곱보다 덧셈이 크다 **
    while plusNumber and plusNumber[0] == 1:
        result += plusNumber.pop(0)
    if len(plusNumber) % 2 == 0:
        for i in range(0, len(plusNumber) - 1, 2):
            result += plusNumber[i] * plusNumber[i + 1]
    else:
        temp2 = plusNumber.pop(0)
        result += temp2
        for i in range(0, len(plusNumber) - 1, 2):
            result += plusNumber[i] * plusNumber[i + 1]

print(result)
