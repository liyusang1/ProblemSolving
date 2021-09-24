#11000
import heapq
from sys import stdin

n = int(stdin.readline())
room = []
for _ in range(n):
    x,y = map(int,stdin.readline().split())
    room.append([x,y])
room.sort()

priorityQueue = []
heapq.heappush(priorityQueue,room[0][1])

for i in range(1,n):
    if room[i][0] < priorityQueue[0]:
        heapq.heappush(priorityQueue,room[i][1])
    else:
        heapq.heappop(priorityQueue)
        heapq.heappush(priorityQueue,room[i][1])
print(len(priorityQueue))