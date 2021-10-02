#1783
from sys import stdin
n,m = map(int,stdin.readline().split())

result = 0
# 위아래로 한칸도 움직일 수 없다.
if n<=1:
    print(1)
#위아래로 한칸씩 이동할 수 있음, 4번이상 이동시 4가지의 방법을 모두 사용해야함 3번 이동이 최대(시작점 때문에 +1)
elif n==2:
    print(min(4,(m+1)//2))
#가로의 길이가 6이하이면 4번 이상 움직이면 1~4번을 따써야하므로 최대값은 4, 최소값은 가로의 길이
elif m<7:
    print(min(4,m))
else:
    print(m-2)
