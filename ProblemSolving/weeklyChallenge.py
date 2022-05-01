def solution(price, money, count):
    totalMoney = 0

    for i in range(1, count + 1):
        totalMoney += i * price

    answer = totalMoney - money
    if answer <= 0:
        answer = 0

    return answer