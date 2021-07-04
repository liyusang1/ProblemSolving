#2021 07 04 알고리즘 완주반

#문제 1
for i in range(9):
    if i%3 == 0:
        continue
    print("*"*i)

#문제 2
a = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']

for i in list(map(int,a)):
    a[i] = str(i+1)

print(a)

#문제 3
a = ['base ball', 'basket ball', 'soccer', 'base ball', 'soccer', 'soccer', 'basket ball', 'base ball', 'basket ball', 'soccer', 'basket ball', 'basket ball', 'base ball', 'soccer', 'soccer', 'basket ball', 'basket ball', 'base ball', 'base ball']

baseballCount = a.count('base ball')
basketballCount = a.count('basket ball')
soccerCount = a.count('soccer')

print("basket ball {}".format(basketballCount))
print("base ball {}".format(baseballCount))
print("soccer {}".format(soccerCount))

#문제 4
for i in range(-1,11,1):
    number=i
    if i>8 : number=8
    if i<0 :
        print(i+1,end=" ")
        continue
    print(2**(number),end=" ")

#문제 5
data1 = (0,1,2,3,4,5,6,7,8)
data2 = [10,11,12,13,14,15,16,17,18,19]

result = list(data1)[:6]+data2[::2]

print(result)

#문제 6
a = ['파','이','썬','썬','썬','썬','즐','즐','즐','거','운']
last = None
for elem in a :
    if elem == last:
        continue
    print(elem,end="")
    last = elem