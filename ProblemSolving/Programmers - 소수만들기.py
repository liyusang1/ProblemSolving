from itertools import combinations


def solution(nums):
    answer = 0

    numberList = list(combinations((nums), 3))
    for i in numberList:
        if checkPrime(sum(i)):
            answer += 1

    return answer


def checkPrime(number):
    for i in range(2, int(number ** (0.5)) + 1):
        if number % i == 0:
            return False
    return True