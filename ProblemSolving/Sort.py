import random

def bubbleSort(list):
    swaped = False
    for index in range(len(list)-1):
        for index2 in range(len(list)-index-1):
            if list[index2] > list[index2+1] :
                list[index2],list[index2+1] = list[index2+1],list[index2]
                swaped = True
            if swaped == False :
                break
    return list

def selectionSort(list):
    for stand in range(len(list)-1):
        lowest = stand
        for index in range(stand+1,len(list)):
            if list[lowest] > list[index]:
                lowest = index
        list[lowest],list[stand] = list[stand],list[lowest]
    return list

def insertionSort(list):
    for index in range(len(list)-1):
        for index2 in range(index+1,0,-1):
            if list[index2] < list[index2-1]:
                list[index2],list[index2 - 1]=list[index2 - 1],list[index2]
            else:
                break
    return list

list = random.sample(range(100),20)
print(insertionSort(list))