# 7490

import itertools
import sys


def getOperator(n):
    operatorList = list(itertools.product([' ', '+', '-'], repeat=n))
    return operatorList


testCase = int(sys.stdin.readline())
result = []

for _ in range(testCase):
    n = int(sys.stdin.readline())
    operatorList = getOperator(n - 1)
    integers = [i for i in range(1, n + 1)]

    for operator in operatorList:
        string = ""
        for i in range(n - 1):
            string += str(integers[i]) + operator[i]
        string += str(integers[-1])
        if eval(string.replace(" ", "")) == 0:
            result.append(string)
    result.append("")

for i in result:
    print(i)
