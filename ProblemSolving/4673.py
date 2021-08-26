# 4673

numberList = []

for i in range(1, 10001):
    if i < 10:
        numberList.append(i + i)
    elif i < 100:
        numberList.append(i + (i // 10) + (i % 10))
    elif i < 1000:
        result = i
        result += i // 100
        i %= 100
        result += i // 10
        i %= 10
        result += i
        numberList.append(result)
    else:
        result = i
        result += i // 1000
        i %= 1000
        result += i // 100
        i %= 100
        result += i // 10
        i %= 10
        result += i
        numberList.append(result)

print(numberList)
for i in range(1, 10000):
    if not i in numberList:
        print(i)
