# 1181

number = int(input())
result = []

for _ in range(number):
    string = input()
    result.append(string)

result = list(set(result))
result.sort()
result.sort(key=len)

for i in result:
    print(i)
