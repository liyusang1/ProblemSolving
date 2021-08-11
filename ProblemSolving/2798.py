# 2798

cardCount, cardSum = map(int, input().split())
cards = list(map(int, input().split()))

maxSum = 0
for i in range(len(cards)):
    for j in range(i + 1, len(cards)):
        for k in range(j + 1, len(cards)):
            sum = cards[i] + cards[j] + cards[k]
            if sum <= cardSum and maxSum < sum:
                maxSum = sum

print(maxSum)
