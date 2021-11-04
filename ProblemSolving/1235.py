# 1235
n = int(input())
numberList = [input() for _ in range(n)]
a = 1
while True:
  if len(set(map(lambda x: x[-a:], numberList))) == n:
    print(a)
    break
  a += 1

