# 1764
from sys import stdin

n, m = map(int, stdin.readline().split())
person = dict()

for _ in range(n):
    name = stdin.readline().rstrip()
    if name in person:
        person[name] += 1
    elif not name in person:
        person[name] = 1

for _ in range(m):
    name = stdin.readline().rstrip()
    if name in person:
        person[name] += 1
    elif not name in person:
        person[name] = 1

result = 0
nameList = []
for name, count in person.items():
    if count >= 2:
        result += 1
        nameList.append(name)

nameList.sort()
print(result)
print("\n".join(nameList))