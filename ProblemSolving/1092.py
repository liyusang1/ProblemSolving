# 1092

from sys import stdin

n = int(stdin.readline())
cranes = list(map(int, stdin.readline().split()))

m = int(stdin.readline())
boxes = list(map(int, stdin.readline().split()))

cranes.sort(reverse=True)
boxes.sort(reverse=True)

# 박스가 더 많은 경우
if max(cranes) < max(boxes):
    print(-1)
    exit()

position = [0] * n
visited = [False] * m

result = 0
count = 0

while True:
    if count == len(boxes):
        break
    for i in range(n):
        while position[i] < len(boxes):
            if not visited[position[i]] and cranes[i] >= boxes[position[i]]:
                visited[position[i]] = True
                position[i] += 1
                count += 1
                break
            position[i] += 1
    result += 1
print(result)
