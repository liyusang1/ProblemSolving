# 14912
answer = 0
n, d = map(int, input().split())
for i in range(1, n + 1):
    answer += str(i).count(str(d))
print(answer)
