#2529
import itertools
from sys import stdin

n = int(stdin.readline())
string = list(stdin.readline().rstrip().split())

perList = list(itertools.permutations([i for i in range(10)],n+1))
result = []
for i in perList:
    check = True
    for j in range(len(i)-1):
        if i[j] > i[j+1] and string[j] == '<':
            check = False
            break
        elif i[j] < i[j+1] and string[j] == '>':
            check = False
            break
    if check==True:
        result.append(i)

number = ("".join(map(str,result[-1])))
print(number)
number = ("".join(map(str,result[0])))
print(number)
