# 14582
from sys import stdin

firstTeam = list(map(int, stdin.readline().strip().split()))
secondTeam = list(map(int, stdin.readline().strip().split()))

firstScore = 0
secondScore = 0
result = False

for i in range(9):
    firstScore += firstTeam[i]
    if firstScore > secondScore:
        result = True
    secondScore += secondTeam[i]

if result and firstScore < secondScore:
    print("Yes")
else:
    print("No")
