#1003

n = int(input())

def fibo(n):
    fiboList = [[0, 0] for i in range(n + 1)]
    fiboList[0] = [1, 0]
    if n == 0:
        return fiboList[n]
    fiboList[1] = [0, 1]
    if n == 1:
        return fiboList[n]

    for i in range(2, n + 1):
        fiboList[i][0] = fiboList[i - 1][0] + fiboList[i - 2][0]
        fiboList[i][1] = fiboList[i - 1][1] + fiboList[i - 2][1]

    return fiboList[n]

for _ in range(n):
    x = int(input())
    result = fibo(x)
    print(" ".join(map(str, result)))
