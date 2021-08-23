# 6603

import itertools

while True:
    n = list(map(int, input().split()))
    if n[0] == 0:
        break
    result = list(itertools.combinations(n[1:], 6))
    for i in result:
        print(" ".join(map(str, i)))
    print()
