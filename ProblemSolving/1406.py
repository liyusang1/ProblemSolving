# 1406
from collections import deque
from sys import stdin

left = deque(list(stdin.readline().strip()))
right = deque()

n = int(stdin.readline())

for _ in range(n):
    order = stdin.readline().split()
    if order[0] == 'L' and left:
        right.appendleft(left.pop())
    elif order[0] == 'D' and right:
        left.append(right.popleft())
    elif order[0] == 'P':
        left.append(order[1])
    elif order[0] == 'B' and left:
        left.pop()

print("".join(left + right))
