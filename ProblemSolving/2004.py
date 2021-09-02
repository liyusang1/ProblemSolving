# 2004
def twoCount(n):
    count = 0
    while n!=0:
        n //= 2
        count +=n
    return count

def fiveCount(n):
    count = 0
    while n!=0:
        n //= 5
        count +=n
    return count

n,m = map(int,input().split())
print(min(twoCount(n)-twoCount(n-m)-twoCount(m),fiveCount(n)-fiveCount(n-m)-fiveCount(m)))