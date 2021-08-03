# Greedy1 - Coin Problem

coinList = [50, 100, 500, 1, 1000]


def greedy1(conList, value):
    conList.sort(reverse=True)
    totalCount = 0
    details = list()

    for i in conList:
        count = value // i
        totalCount += count
        value -= count * i
        details.append([i, count])

    return totalCount, details


print(greedy1(coinList, 32961))

# Greedy2 - Fractional Knapsack Problem

dataList = [(10, 10), (15, 12), (20, 10), (25, 8), (30, 5)]


def knapsack(dataList, capacity):
    dataList = sorted(dataList, key=lambda x: x[1] / x[0], reverse=True)
    details = list()
    totalValue = 0

    for i in dataList:
        if capacity - i[0] >= 0:
            capacity -= i[0]
            totalValue += i[1]
            details.append([i[0], i[1], 1])
        else:
            fractions = capacity / i[0]
            totalValue += fractions * i[1]
            details.append([i[0], i[1], fractions])
            break
    return totalValue, details


print(knapsack(dataList, 30))
