# k번째 수
def solution(array, commands):
    result = []
    for i in range(len(commands)):
        temp = list(array[commands[i][0]-1:commands[i][1]])
        temp.sort()
        key = commands[i][2]
        result.append(temp[key - 1])
    return result

solution([1, 5, 2, 6, 3, 7, 4],[[2, 5, 3], [4, 4, 1], [1, 7, 3]])