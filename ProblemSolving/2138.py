# 2138
#첫 번째 전구를 켰느냐 안켰느냐로 경우의 수를 나누어 주어야 함 (핵심 포인트)
#나누면 그냥 그리디로 쉽게 풀림
#but 두 가지 경우의 수를 나누고 둘 다 되는 경우일 때 작은 값을 출력해야 하는데 둘다 되는 경우를 생각하지 않아서 시간 날림
from sys import stdin

def change(x):
    for i in range(x - 1, x + 2):
        if i < 0 or i >= n:
            continue
        if light1[i] == 0:
            light1[i] = 1
        else:
            light1[i] = 0


n = int(stdin.readline())

light1 = list(map(int, stdin.readline().rstrip()))
light2 = list(map(int, stdin.readline().rstrip()))
temp = light1.copy()

count = 1
change(0)
for i in range(1, len(light1)):
    if light1[i - 1] != light2[i - 1]:
        change(i)
        count += 1

count2 = 0
if light1 != light2:
    count = -1

light1 = temp
for i in range(1, len(light1)):
    if light1[i - 1] != light2[i - 1]:
        change(i)
        count2 += 1
if light1 != light2:
    count2 = -1

if count < 0 and count2 < 0:
    print(-1)
elif count >= 0 and count2 >= 0:
    print(min(count, count2))
elif count < 0 and count2 >= 0:
    print(count2)
else:
    print(count)
