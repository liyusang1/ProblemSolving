# 11653

n = int(input())

i = 2
while n != 1:
    if n % i == 0:
        n //= i
        print(i)
    else:
        i += 1
