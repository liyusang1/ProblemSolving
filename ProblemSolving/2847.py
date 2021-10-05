#2847
from sys import stdin

n = int(stdin.readline())
myList = []

for _ in range(n):
    myList.append(int(stdin.readline()))

result = 0


def solution():
    global result
    for i in range(len(myList) - 1):
        while myList[i] >= myList[i + 1]:
            myList[i] -= 1
            result += 1


for _ in range(n - 1):
    solution()

print(result)