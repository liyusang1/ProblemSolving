#2331
def solution(x) :
    x = int(x) ** m
    return x

n, m = map(int, input().split())
first = [n]
i = 0

while True :
    i += 1
    num = sum(map(solution, str(first[i - 1])))
    if num in first :
        break
    first.append(num)

print(first.index(num))