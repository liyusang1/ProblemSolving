#1157

string = input().upper()

result = dict()

for i in string:
    if i in result:
        result[i] += 1
    else:
        result[i] = 1

maxNum = max(result.values())
result2 = list()

for i in result:
    if result[i] == maxNum:
        result2.append(i)

if len(result2) > 1:
    print('?')
else:
    print("".join(result2))