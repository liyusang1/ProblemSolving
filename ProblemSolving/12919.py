# 12919

from sys import stdin

s, t = [list(stdin.readline().strip()) for _ in range(2)]


def DFS(string):
    if len(string) == len(s):
        if string == s:
            print(1)
            exit(0)
        return

    if string[0] == 'B':
        string = string[::-1]
        string.pop()
        DFS(string)

        string.append('B')
        string = string[::-1]

    if string[-1] == 'A':
        string.pop()
        DFS(string)

        string.append('A')


DFS(t)
if not DFS(t):
    print(0)
