#9012

n = int(input())
result = []

for _ in range(n):
    stack1 = list(input())
    stack2 = []
    for i in stack1:
        if len(stack2) > 0 and i == ')' and stack2[-1] == '(':
            stack2.pop()
        elif i == '(' or i == ')':
            stack2.append(i)
    if len(stack2) == 0:
        result.append('YES')
    else:
        result.append('NO')

for i in result:
    print(i)
