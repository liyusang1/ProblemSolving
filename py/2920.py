# 2920

list1 = list(map(int, input().split()))


def check(list):
    if list[0] == 1:
        for i in range(1, len(list)):
            if list[i] != list[i - 1] + 1:
                return 'mixed'
        return 'ascending'
    elif list[0] == 8:
        for i in range(1, len(list)):
            if list[i] != list[i - 1] - 1:
                return 'mixed'
        return 'descending'
    else:
        return 'mixed'


print(check(list1))


def check2(list):
    ascending = True
    descending = True
    for i in range(1, len(list)):
        if list1[i] > list1[i - 1]:
            descending = False
        elif list1[i] < list1[i - 1]:
            ascending = False

    if ascending == False and descending == False:
        return 'mixed'
    elif ascending == True and descending == False:
        return 'ascending'
    else:
        return 'descending'


print(check2(list1))
