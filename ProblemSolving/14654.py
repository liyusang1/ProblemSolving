# 14654
N = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
result = []


def match(a, b):
    if a == b:
        return result[-1] * -1
    elif abs(a - b) == 1:
        if a > b:
            return 1
        else:
            return -1
    else:
        if a > b:
            return -1
        else:
            return 1


for i in range(N):
    result.append(match(a[i], b[i]))
result.append(0)
maxValue = 0
streak = 1
for i in range(N):
    if result[i] != result[i + 1]:
        maxValue = max(maxValue, streak)
        streak = 1
    else:
        streak += 1
print(maxValue)
