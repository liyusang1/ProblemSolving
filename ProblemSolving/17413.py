# 17413

string = list(input())

n = 0

while n < len(string):
    if string[n] == '<':
        n += 1
        while string[n] != '>':
            n += 1
        n += 1
    elif string[n].isalnum():
        start = n
        while n < len(string) and string[n].isalnum():
            n += 1
        temp = string[start:n]
        temp.reverse()
        string[start:n] = temp
    else:
        n += 1

print("".join(string))
