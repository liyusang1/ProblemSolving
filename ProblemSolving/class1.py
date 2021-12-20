from sys import stdin

# 저장 값을 상수로 저장
WALL = 0
HALL = 1
BALL = 2
PLAYER = 3
STAGEDIVISION = 4

stage = [[] for i in range(100)]
start = 0


# 입력값에 따라 2차원에 배열에 알맞는 값을 저장하는 함수
def saveToArray(input):
    global start
    for i in input:
        if i == '#':
            stage[start].append(WALL)
        elif i == 'O':
            stage[start].append(HALL)
        elif i == 'o':
            stage[start].append(BALL)
        elif i == 'P':
            stage[start].append(PLAYER)
        elif i == '=':
            stage[start].append(STAGEDIVISION)
        else:
            stage[start].append(i)
    start += 1


    # 스테이지 정보를 출력하는 함수
def printArray():
    width = 0
    height = 0
    hallCount = 0
    ballCount = 0
    startNumber = 1

    for i in range(len(stage)):
        height += 1
        if not stage[i]:
            height -= 1
            break
        if stage[i][0] != 'S':
            # 가로길이를 max함수를 통해 결정 (최대 길이가 가로길이가 된다)
            width = max(len(stage[i]), width)
        for j in range(len(stage[i])):
            if stage[i][j] == 'S':
                tempX = i
                tempY = j
                print("Stage {}".format(startNumber))
                startNumber += 1
                break
            if stage[i][j] == 0:
                print("#", end='')
            elif stage[i][j] == ' ':
                print(" ", end='')
            elif stage[i][j] == 1:
                hallCount += 1
                print("O", end='')
            elif stage[i][j] == 2:
                ballCount += 1
                print("o", end='')
            elif stage[i][j] == 3:
                print("P", end='')
                # 사용자의 위치를 결정 tempX와 tempY의 값만큼을 뺀 값이 사용자의 위치이다 (배열에서 불필요한 값 또는 이전 스테이지의 값을 만큼을 빼는 것)
                playerLocation = (i - tempX, j - tempY + 1)
            elif stage[i][j] == 4:
                height -= 1
                printInformation(width, height, hallCount, ballCount, playerLocation)

                # 하나의 스테이지가 종료되었으니 모든 값을 0으로 초기화 해 줌
                width = 0
                height = 0
                hallCount = 0
                ballCount = 0
                break
        print()
    ## 남은 stage 출력
    printInformation(width, height, hallCount, ballCount, playerLocation)


# 스테이지 정보를 출력하는 함수2
def printInformation(width, height, hallCount, ballCount, playerLocation):
    print()
    print("가로크기 : {}".format(width))
    print("세로크기 : {}".format(height - 1))
    print("구멍의 수 : {}".format(hallCount))
    print("공의 수: {}".format(ballCount))
    print("플레이어 위치 {}".format(playerLocation))


while True:
    input = stdin.readline().rstrip()
    if not input:
        break
    saveToArray(input)

printArray()
