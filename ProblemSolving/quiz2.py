from sys import stdin

STARTXPOSITION = 3
STARTYPOSITION = 5

stage = [[' ', ' ', '#', '#', '#', '#', '#', '#', '#', ' ', ' '],
         ['#', '#', '#', ' ', ' ', 'O', ' ', ' ', '#', '#', '#'],
         ['#', ' ', ' ', ' ', ' ', 'o', ' ', ' ', ' ', ' ', '#'],
         ['#', ' ', 'O', 'o', ' ', 'P', ' ', 'o', 'O', ' ', '#'],
         ['#', '#', '#', ' ', ' ', 'O', ' ', ' ', '#', '#', '#'],
         [' ', '#', ' ', ' ', ' ', 'O', ' ', ' ', '#', ' ', ' '],
         [' ', '#', '#', '#', '#', '#', '#', '#', '#', ' ', ' '],
         ]

playerXPosition = STARTXPOSITION
playerYPosition = STARTYPOSITION


def move(order):
    global playerXPosition
    global playerYPosition

    if order == 'w':
        playerXPosition -= 1
        if moveCheck(playerXPosition, playerYPosition):
            playerXPosition += 1
            warning(order)
            printStage()
        else:
            stage[playerXPosition][playerYPosition] = 'P'
            stage[playerXPosition + 1][playerYPosition] = ' '
            print("{}: 위쪽으로 이동합니다.\n".format(order))
            printStage()
    elif order == 'a':
        playerYPosition -= 1
        if moveCheck(playerXPosition, playerYPosition):
            playerYPosition += 1
            warning(order)
            printStage()
        else:
            stage[playerXPosition][playerYPosition] = 'P'
            stage[playerXPosition][playerYPosition + 1] = ' '
            print("{}: 왼쪽으로 이동합니다.\n".format(order))
            printStage()
    elif order == 's':
        playerXPosition += 1
        if moveCheck(playerXPosition, playerYPosition):
            playerXPosition -= 1
            warning(order)
            printStage()
        else:
            stage[playerXPosition][playerYPosition] = 'P'
            stage[playerXPosition - 1][playerYPosition] = ' '
            print("{}: 아래쪽으로 이동합니다.\n".format(order))
            printStage()
    elif order == 'd':
        playerYPosition += 1
        if moveCheck(playerXPosition, playerYPosition):
            playerYPosition -= 1
            warning(order)
            printStage()
        else:
            stage[playerXPosition][playerYPosition] = 'P'
            stage[playerXPosition][playerYPosition - 1] = ' '
            print("{}: 오른쪽으로 이동합니다.\n".format(order))
            printStage()
    else:
        warning(order)
        printStage()


def warning(order):
    print()
    print("{}: (경고!) 해당 명령을 수행할 수 없습니다!\n".format(order))


def moveCheck(playerXPosition, playerYPosition):
    if stage[playerXPosition][playerYPosition] == 'o' or stage[playerXPosition][playerYPosition] == 'O' or \
            stage[playerXPosition][playerYPosition] == '#':
        return True


def printStage():
    for i in stage:
        for j in i:
            print(j, end="")
        print()


print("Stage2\n")
printStage()
print()

while True:
    print('SOKOBAN> ', end='')
    orderList = list(stdin.readline().rstrip())
    print()
    if orderList[0] == 'q':
        break
    for i in orderList:
        move(i)
    print()

print("Bye~")
