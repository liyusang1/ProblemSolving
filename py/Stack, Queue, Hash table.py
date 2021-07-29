queueList = list()
stackList = list()


# Queue
def enqueue(data):
    queueList.append(data)


def dequeue(data):
    data = queueList[0]
    del queueList[0]
    return data


# Stack
def push(data):
    stackList.append(data)


def pop():
    data = stackList[-1]
    del stackList[-1]
    return data


# hash table

hashTable = [i for i in range(10)]


def getKey(data):
    return hash(data)


def hashFunction(key):
    return key % 8


def saveData(data, value):
    hashAddress = hashFunction(getKey(data))
    hashTable[hashAddress] = value


def readData(data):
    hashAddress = hashFunction(getKey(data))
    return hashTable[hashAddress]


saveData('Andrew', '01011111111')
saveData('SsamMu', '01022222222')
print(readData('SsamMu'))

