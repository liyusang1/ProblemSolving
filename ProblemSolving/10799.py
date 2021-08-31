# 10799
string = input()
stack = []
result = 0
n = 0

while n < len(string):
    if string[n] == '(':
        if string[n + 1] == ')':
            n += 2
            result += len(stack)
        else:
            stack.append(string[n])
            n += 1
    elif string[n] == ')' and stack:
        stack.pop()
        result += 1
        n += 1

print(result)
