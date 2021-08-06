# 1021

from collections import deque
import sys

input = sys.stdin.readline

n, count = map(int, input().split())

indexList = list(map(int, (input().split())))
queue = deque([i for i in range(1, n + 1)])

count = 0

for _ in indexList:
    while True:
        if queue[0] == _:
            queue.popleft()
            break
        else:
            if queue.index(_) < len(queue) / 2:
                queue.append(queue.popleft())
                count += 1
            else:
                queue.appendleft(queue.pop())
                count += 1

print(count)
