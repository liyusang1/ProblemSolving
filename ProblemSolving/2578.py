# 2578
bingo = []
for _ in range(5):
    bingo.append(list(map(int, input().split())))

num = list(map(int, input().split()))
for _ in range(4):
    num += list(map(int, input().split()))

check = [0] * 12
line = 0
flag = False
for n in range(25):
    if flag == True:
        break
        if flag == True:
            break
        for j in range(5):
            if flag == True:
                break
            if num[n] == bingo[i][j]:
                bingo[i][j] = 0
                check[i] += 1
                check[j + 5] += 1
                if i == j:
                    check[10] += 1
                if i + j == 4:
                    check[11] += 1
                for c in range(12):
                    if check[c] == 5:
                        check[c] = 0
                        line += 1
                        if line == 3:
                            flag = True
                            break
print(n)
