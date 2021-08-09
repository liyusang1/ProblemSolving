# 1259

list1 = []

while True:
    userInput = input()
    if userInput == '0':
        break
    else:
        list1.append(userInput)


def check(i):
    for j in range(len(i) // 2):
        if i[j] != i[-1 - j]:
            return "no"
    return "yes"


for i in list1:
    print(check(i))
