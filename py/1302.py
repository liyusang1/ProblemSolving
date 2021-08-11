# 1302

n = int(input())
result = dict()

for _ in range(n):
    book = input()

    if book not in result:
        result[book] = 1
    else:
        result[book] += 1

result = sorted(result.items())
print(max(result, key=lambda x: x[1])[0])
