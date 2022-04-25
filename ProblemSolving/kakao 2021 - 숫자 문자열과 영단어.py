english = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']

def solution(s):
    answer = 0
    for idx, number in enumerate(english):
        if number in s:
            s = s.replace(number, str(idx))
        answer = s

    return int(answer)
