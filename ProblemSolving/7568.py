# 7568

n = int(input())

person = [list(map(int, input().split())) for i in range(n)]
result = [1 for i in range(n)]

for i in range(len(person) - 1):
    for j in range(i, len(person)):
        if person[i][0] > person[j][0] and person[i][1] > person[j][1]:
            result[j] += 1
        elif person[i][0] < person[j][0] and person[i][1] < person[j][1]:
            result[i] += 1

print(" ".join(map(str,result)))
