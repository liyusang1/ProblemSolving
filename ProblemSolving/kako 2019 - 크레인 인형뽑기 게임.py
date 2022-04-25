def solution(board, moves):
    answer = 0
    selected = []

    stacks = [[] for i in range(len(board[0]))]

    for i in board:
        for j in range(len(board)):
            stacks[j].append(i[j])

    for i in moves:
        for k in range(len(stacks[i - 1])):
            if stacks[i - 1][k] != 0:
                if len(selected) != 0:
                    if selected[-1] == stacks[i - 1][k]:
                        answer += 2
                        selected.pop()
                    else:
                        selected.append(stacks[i - 1][k])
                else:
                    selected.append(stacks[i - 1][k])

                stacks[i - 1][k] = 0
                break
    return answer