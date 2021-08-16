# 1236

col, row = map(int, input().split())
castle = []

for i in range(col):
    castle.append(input())

colCount = 0
for i in range(col):
    guard = False
    for j in range(row):
        if castle[i][j] == 'X':
            guard = True
            break
    if guard == False:
        colCount += 1

rowCount = 0
for i in range(row):
    guard = False
    for j in range(col):
        if castle[j][i] == 'X':
            guard = True
            break
    if guard == False:
        rowCount += 1

print(max(colCount, rowCount))
