# 17219
from sys import stdin

n, m = map(int, stdin.readline().rstrip().split())

passWord = dict()
for _ in range(n):
    site, password = stdin.readline().rstrip().split()
    if not site in passWord:
        passWord[site] = password

for i in range(m):
    site = stdin.readline().rstrip()
    print(passWord[site])
