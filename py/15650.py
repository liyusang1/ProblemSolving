#15650

import itertools

number, count = map(int, input().split())

answerList = list(itertools.combinations([i for i in range(1, number + 1)], count))

for i in answerList:
    print(' '.join(map(str, i)))
