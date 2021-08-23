import sys


def nextPermutation(list1):
    k = -1
    m = -1

    for i in range(len(list1) - 1):
        if list1[i] < list1[i + 1]:
            k = i

    if k == -1:
        return [-1]

    for i in range(k, len(list1)):
        if list1[k] < list1[i]:
            m = i

    list1[k], list1[m] = list1[m], list1[k]

    list1 = list1[:k + 1] + sorted(list1[k + 1:])
    return list1


n = int(sys.stdin.readline())
permutation = list(map(int, sys.stdin.readline().split()))

for num in nextPermutation(permutation):
    print(num, end=' ')
