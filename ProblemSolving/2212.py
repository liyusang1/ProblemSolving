# 2212
from sys import stdin

n = int(stdin.readline())
m = int(stdin.readline())

#예외 처리 중요 포인트
if m>=n:
    print(0)
    exit()
locationList = list(map(int, stdin.readline().split()))
locationList.sort()

#핵심 아이디어 각 거리리의 차이를 계산한후 정렬하여 m값에 따라 큰것을 빼준다
distanceList = [locationList[i] - locationList[i - 1] for i in range(1,n)]
distanceList.sort(reverse=True)

for _ in range(m - 1):
    distanceList.pop(0)
print(sum(distanceList))