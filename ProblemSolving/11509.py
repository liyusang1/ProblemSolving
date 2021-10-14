#11509
from sys import stdin

n = int(stdin.readline())
height = list(map(int,stdin.readline().split()))

count = [0] * (n+1)
result = 0

for i in height:
    if count[i] >0 :
        count[i] -=1
        count[i-1] +=1
    else:
        # 풍선을 맞추고 -1이 되는 경우
        count[i-1] +=1
        result +=1

print(result)