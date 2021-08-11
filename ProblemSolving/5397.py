# 5397

testCase = int(input())
result = []

for _ in range(testCase):
    key = list(input())
    leftStack = []
    rightStack = []

    for i in range(len(key)):
        if key[i] == '>':
            if len(rightStack) == 0:
                continue
            else:
                leftStack.append(rightStack.pop())
        elif key[i] == '<':
            if len(leftStack) == 0:
                continue
            else:
                rightStack.append(leftStack.pop())
        elif key[i] == '-':
            if len(leftStack) == 0:
                continue
            else:
                leftStack.pop()
        else:
            leftStack.append(key[i])
    leftStack.extend(reversed(rightStack))
    result.append("".join(leftStack))

print("\n".join(result))
