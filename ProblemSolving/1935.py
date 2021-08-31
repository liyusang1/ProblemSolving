# 1935
from sys import stdin

n = int(stdin.readline())

string = list(stdin.readline().rstrip())
numberList = [stdin.readline().rstrip() for _ in range(n)]
stack1 = []
alp = {'A': 0, 'B': 1, 'C': 2, 'D': 3, 'E': 4, 'F': 5, 'G': 6, 'H': 7, 'I': 8, 'J': 9, 'K': 10, 'L': 11, 'M': 12,
       'N': 13, 'O': 14, 'P': 15, 'Q': 16, 'R': 17, 'S': 18, 'T': 19, 'U': 20,
       'V': 21, 'W': 22, 'X': 23, 'Y': 24, 'Z': 25}

for i in range(len(string)):
    if string[i].isalnum():
        stack1.append(numberList[alp[string[i]]])

    elif not string[i].isalnum():
        num2 = str(stack1.pop())
        num1 = str(stack1.pop())

        calculate = eval(num1 + string[i] + num2)
        stack1.append(calculate)

print(format(stack1[0],".2f"))

