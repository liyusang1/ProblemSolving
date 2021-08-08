# 1247

result = []

for _ in range(3):
    number = int(input())
    sum = 0
    for i in range(number):
        insert = int(input())
        sum += insert
    if sum > 0:
        result.append("+")
    elif sum < 0:
        result.append("-")
    else:
        result.append("0")

print("\n".join(result))
