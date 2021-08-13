# 2110
import sys

house, count = map(int, sys.stdin.readline().split())
houseList = [int(sys.stdin.readline()) for _ in range(house)]
houseList = sorted(houseList)

start = 1
end = houseList[-1] - houseList[0]


def countCheck(distance):
    count = 1
    current = houseList[0]
    for i in range(1, len(houseList)):
        if houseList[i] >= distance + current:
            count += 1
            current = houseList[i]
    return count


while start <= end:
    mid = (start + end) // 2

    if countCheck(mid) >= count:
        answer = mid
        start = mid + 1
    else:
        end = mid - 1

print(answer)
