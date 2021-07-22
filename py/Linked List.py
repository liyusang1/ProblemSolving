class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class LinkedList:
    def __init__(self, data):
        self.head = Node(data)

    def add(self, data):
        if self.head == None:
            self.head = Node(data)
        else:
            node = self.head
            while node.next:
                node = node.next
            node.next = Node(data)

    def print(self):
        node = self.head
        while node:
            print(node.data)
            node = node.next

    def delete(self, data):
        if self.head.data == data:
            temp = self.head
            self.head = self.head.next
            del temp
        else:
            node = self.head
            while node.next:
                if node.next.data == data:
                    temp = node.next
                    node.next = node.next.next
                    del temp
                    return
                else:
                    node = node.next


linkedlist1 = LinkedList(0)
for data in range(2, 10):
    linkedlist1.add(data)
linkedlist1.print()

linkedlist1.delete(4)
print("")
linkedlist1.print()
