# 1789

n = int(input())

result = 1
while result * (result + 1) / 2 <= n:
    result += 1
print(result - 1)
