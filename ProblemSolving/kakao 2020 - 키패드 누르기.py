number = {'*': [0, 0], '0': [0, 1], '#': [0, 2],
          '7': [1, 0], '8': [1, 1], '9': [1, 2],
          '4': [2, 0], '5': [2, 1], '6': [2, 2],
          '1': [3, 0], '2': [3, 1], '3': [3, 2]
          }


def solution(numbers, hand):
    answer = ''
    left = number['*']
    right = number['#']

    for i in numbers:
        if str(i) == '1' or str(i) == '4' or str(i) == '7':
            answer += 'L'
            left = number[str(i)]
        elif str(i) == '3' or str(i) == '6' or str(i) == '9':
            answer += 'R'
            right = number[str(i)]
        else:
            leftDistance = abs(number[str(i)][0] - left[0]) + abs(number[str(i)][1] - left[1])
            rightDistance = abs(number[str(i)][0] - right[0]) + abs(number[str(i)][1] - right[1])

            if leftDistance < rightDistance:
                left = number[str(i)]
                answer += 'L'
            elif leftDistance > rightDistance:
                right = number[str(i)]
                answer += 'R'
            else:
                if hand == 'right':
                    right = number[str(i)]
                    answer += 'R'
                else:
                    left = number[str(i)]
                    answer += 'L'

    return answer
