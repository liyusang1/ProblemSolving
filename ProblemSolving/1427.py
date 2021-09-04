#1427
string = list(str(input()))
numberList = [int(i) for i in string]

def quickSort(list):
    if len(list) <= 1:
        return list
    pivot = list[0]
    left = [items for items in list[1:] if items < pivot]
    right = [items for items in list[1:] if items >= pivot]
    return quickSort(left) + [pivot] + quickSort(right)

#numberList = quickSort(numberList)
#numberList.reverse()
numberList.sort(reverse=True)

for _ in numberList:
    print(_,end="")

