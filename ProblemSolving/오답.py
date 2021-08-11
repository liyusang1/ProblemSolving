#1주차 - 과제3
a = ['base ball', 'basket ball', 'soccer', 'base ball', 'soccer', 'soccer', 'basket ball', 'base ball', 'basket ball', 'soccer', 'basket ball', 'basket ball', 'base ball', 'soccer', 'soccer', 'basket ball', 'basket ball', 'base ball', 'base ball']
for sport in set(a):
    print(sport, a.count(sport))

#1주차 - 과제2
a = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
a = list(map(lambda x: str(int(x) + 1), a))
print(a)