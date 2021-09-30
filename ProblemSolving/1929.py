#1929

n1, n2 = map(int, input().split())
numberList = [i for i in range(n1, n2 + 1)]
result = []

for i in numberList:
    check = True
    if i == 1:
        continue
    for j in range(2, int(i**0.5)+1):
        if i % j == 0:
            check = False
            break
    if check:
        result.append(i)

print("\n".join(map(str,result)))