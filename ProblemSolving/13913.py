from collections import deque

def path(x):
    arr = []
    temp = x
    for _ in range(count[x] + 1):
        arr.append(temp)
        temp = move[temp]
    print(' '.join(map(str, arr[::-1])))

def bfs():
    q = deque()
    q.append(N)
    while q:
        x = q.popleft()
        if x == K:
            print(count[x])
            path(x)
            return x
        for i in (x + 1, x - 1, 2 * x):
            if 0 <= i <= 100000 and count[i] == 0:
                q.append(i)
                count[i] = count[x] + 1
                move[i] = x

N, K = map(int, input().split())
count = [0] * 100001
move = [0] * 100001
bfs()