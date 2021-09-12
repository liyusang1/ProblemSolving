#11047
from sys import stdin

coinCount, price = map(int, stdin.readline().split())

coinList = []
for i in range(coinCount):
    coinList.append(int(stdin.readline()))
coinList.sort(reverse=True)

result = 0
for i in coinList:
    result += price // i
    price %= i
print(result)
