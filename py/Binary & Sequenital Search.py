def binarySearch(list, search):
    print(list)
    if len(list) == 1 and list[0] == search:
        return True
    if len(list) == 1 and list[0] != search:
        return False
    if len(list) == 0:
        return False

    medium = len(list) // 2
    if list[medium] == search:
        return True
    else:
        if list[medium] < search:
            return binarySearch(list[medium + 1:], search)
        else:
            return binarySearch(list[:medium], search)


def sequentialSearch(list, search):
    for index in range(len(list)):
        if list[index] == search:
            return True
    return False


import random

list = random.sample(range(50), 20)
list.sort()
print(binarySearch(list, 31))

list2 = random.sample(range(50), 20)
print(list2)
print(sequentialSearch(list2, 31))
