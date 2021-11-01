# 1316

n = int(input())

result = 0
for _ in range(n):
    word = input()
    error = 0
    for index in range(len(word) - 1):
        if word[index] != word[index + 1]:
            newWord = word[index + 1:]
            if newWord.count(word[index]) > 0:
                error += 1
    if error == 0:
        result += 1
print(result)
