class Person:
    def __init__(self, name, age):
        self.__name = name  # Private attribute
        self.__age = age    # Private attribute

    def get_name(self):
        return self.__name  # Public method to access the private attribute

    def get_age(self):
        return self.__age    # Public method to access the private attribute

# Creating an instance of the Person class
person = Person("Eli", 24)

# Accessing public methods
print(person.get_name())  # Output: Eli
print(person.get_age())   # Output: 24