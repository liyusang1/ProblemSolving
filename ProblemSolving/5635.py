#5635
from sys import stdin

n = int(stdin.readline())
result = []

for _ in range(n):
    name,month,day,year = stdin.readline().strip().split()
    result.append([name,int(month),int(day),int(year)])

result.sort(key=lambda x:(x[3],x[2],x[1]))

print(result[-1][0])
print(result[0][0])
