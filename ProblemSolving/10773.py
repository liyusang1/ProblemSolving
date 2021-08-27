#10773

n = int(input())

stack = []

for _ in range(n):
    x = int(input())
    if x==0:
        stack.pop()
    else:
        stack.append(x)

print(sum(stack))
