#과제 2
class Median:
    def __init__(self):
        self.list1 = [];

    def get_item(self, item):
        self.list1.append(item)

    def clear(self):
        self.list1.clear()

    def show_result(self):
        self.list1.sort()
        if len(self.list1)%2==0 :
            middle1 = int(len(self.list1)/2)
            middle2 = middle1-1
            print((self.list1[middle1]+self.list1[middle2])/2)
        else:
            middle = int(len(self.list1)/2)
            print(self.list1[middle])

median = Median()
for x in range(10):
    median.get_item(x)
median.show_result()

median.clear()
for x in [0.5, 6.2, -0.4, 9.6, 0.4]:
    median.get_item(x)
median.show_result()

#과제3
class Animal:
    def __init__(self, name):
        self.name = name

    def speak(self):
        print(self.name + ' cannot speak.')

    def move(self):
        print(self.name + ' cannot move.')

class Dog(Animal):
    def move(self):
        print(self.name + ' moves like a jagger.')


class Retriever(Dog):
    def speak(self):
        print(self.name + ' is smart enough to speak')

dog = Dog('Nancy')
dog.speak()
dog.move()

super_dog = Retriever('Michael')
super_dog.speak()
super_dog.move()