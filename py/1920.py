# 1920


count = int(input())
numberList = set(map(int, input().split()))

testCase = int(input())
numberList2 = list(map(int, input().split()))

for i in numberList2:
    if i in numberList:
        print(1)
    else:
        print(0)
