# 4195
def find(x):
    if x == parent[x]:
        return x
    else:
        p = find(parent[x])
        parent[x] = p
        return parent[x]


def union(x, y):
    x = find(x)
    y = find(y)

    if x != y:
        parent[y] = x
        number[x] += number[y]


testCase = int(input())
result = []

for _ in range(testCase):
    parent = dict()
    number = dict()

    count = int(input())

    for i in range(count):
        x, y = input().split(" ")

        if x not in parent:
            parent[x] = x
            number[x] = 1
        if y not in number:
            parent[y] = y
            number[y] = 1
        union(x, y)
        result.append(number[find(x)])

for i in result:
    print(i)
