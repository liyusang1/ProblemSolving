# 1748

testCase = input()
testLen = len(testCase) - 1

# 1-9까지 합자리수 9*10^0*1
# 10-99까지 합자리수 9*10^1*2
count = 0
for _ in range(testLen):
    count += 9 * (10 ** _) * (_ + 1)

count += (int(testCase) - (10 ** testLen) + 1) * (testLen + 1)
print(count)
