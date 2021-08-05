#union find algorithm

def find(x):
    if x == parent[x]:
        return x
    else:
        p = find(parent[x])
        parent[x] = p
        return parent[x]

def union(x,y):
    x = find(x)
    y = find(y)

    parent[y] = x

parent = [i for i in range(0,5)]

union(1,4)
union(2,4)
union(3,4)

for i in range(1,len(parent)):
    print(find(i),end=' ')

print(parent)


