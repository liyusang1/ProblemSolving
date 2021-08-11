# 15651

import itertools

number, count = map(int, input().split())

answerList = list(itertools.product([i for i in range(1, number + 1)], repeat=count))

for i in answerList:
    print(' '.join(map(str, i)))
