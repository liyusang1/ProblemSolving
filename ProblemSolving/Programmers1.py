def solution(absolutes, signs):
    answer = 0

    for i in range(len(absolutes)):
        if signs[i]:
            anwser += absolutes[i]
        else:
            answer += -1 * absolutes[i]

    return answer
