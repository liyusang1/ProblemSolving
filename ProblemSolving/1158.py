# 1158
from collections import deque

result = []
count, number = map(int, input().split())

myList = deque([str(i + 1) for i in range(count)])
start = 0

while len(myList) != 0:
    start += 1
    if start < number:
        myList.append(myList.popleft())
    if start == number:
        result.append(myList.popleft())
        start = 0

print("<%s>" %(", ".join(result)))