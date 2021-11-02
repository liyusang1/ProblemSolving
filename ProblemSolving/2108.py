#2108
import sys
from collections import Counter
n = int(sys.stdin.readline())
numbers = []
for i in range(n):
    numbers.append(int(sys.stdin.readline()))
numbers.sort()
result = Counter(numbers).most_common()
print(round(sum(numbers) / n))
print(numbers[n // 2])
if len(result) > 1:
    if result[0][1] == result[1][1]:
        print(result[1][0])
    else:
        print(result[0][0])
else:
    print(result[0][0])
print(numbers[-1] - numbers[0])