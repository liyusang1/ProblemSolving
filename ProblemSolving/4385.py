#4385

from sys import stdin

tree = dict()
count = 0

while True:
    string = stdin.readline().rstrip()

    if not string:
        break

    if not string in tree:
        tree[string] = 1
        count += 1
    elif string in tree:
        tree[string] += 1
        count += 1

for treeName, treeCount in tree.items():
    tree[treeName] = (treeCount / count) * 100

tree = sorted(tree.items())

for x, y in tree:
    print(x, format(y, ".4f"))
