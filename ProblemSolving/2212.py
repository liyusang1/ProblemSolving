# 2212
from sys import stdin

n = int(stdin.readline())
m = int(stdin.readline())
locationList = list(map(int, stdin.readline().split()))
locationList.sort()

distanceList = []

# * 핵심아이디어 -> 오름차순으로 정렬을 한 후 각 위치의 길이를 저장해서 길이가 긴 거리를 m값에 따라 빼준다.
for i in range(1, n):
    distanceList.append(locationList[i] - locationList[i - 1])
distanceList.sort(reverse=True)

for _ in range(m - 1):
    # **예외 처리 실수하지 말기.
    if len(distanceList) == 0:
        break
    distanceList.pop(0)
print(sum(distanceList))
