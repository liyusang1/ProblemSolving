# 2839

n = int(input())

result = 0
while n >= 1:
    if n % 5 == 0:
        result += n // 5
        n %= 5
        break
    n -= 3
    result += 1

if n != 0:
    print(-1)
else:
    print(result)
