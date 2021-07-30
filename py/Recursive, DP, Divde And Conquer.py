# Memoization
def fibo(value):
    list = [0 for i in range(value + 1)]
    list[0] = 0
    list[1] = 1

    for i in range(2, value + 1):
        list[i] = list[i - 1] + list[i - 2]
    return list[value]


def fibo2(value):
    if value <= 1:
        return value

    else:
        return fibo2(value - 1) + fibo2(value - 2)

print(fibo(3))
print(fibo2(3))


# Recursive
def check(string):
    if len(string) <= 1:
        return True
    if string[0] == string[-1]:
        return check(string[1:-1])
    else:
        return False


# QuickSort
def quickSort(list):
    if len(list) <= 1:
        return list
    pivot = list[0]
    left = [items for items in list[1:] if items < pivot]
    right = [items for items in list[1:] if items >= pivot]
    return quickSort(left) + [pivot] + quickSort(right)


# MergeSort
def mergeSort(data):
    if len(data) <=1:
        return data
    medium = len(data)//2
    left = mergeSort(data[:medium])
    right = mergeSort(data[medium:])
    return merge(left,right)

def merge(left, right):
    merged = list()
    leftPoint,rightPoint = 0,0

    while len(left) >leftPoint and len(right)>rightPoint:
        if left[leftPoint] > right[rightPoint]:
            merged.append(right[rightPoint])
            rightPoint += 1
        else:
            merged.append(left[leftPoint])
            leftPoint += 1

    while len(left) > leftPoint :
        merged.append(left[leftPoint])
        leftPoint +=1

    while len(right) > rightPoint :
        merged.append(right[rightPoint])
        rightPoint +=1

    return merged