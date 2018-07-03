from AbstractRentable import AbstractRentable

class Rental(AbstractRentable):
    def __init__(self, quantity):
        self.quantity = quantity
        self.cost = 0

    def getTotalCost(self):
        raise ValueError('Override this method, this class must not be instantiated directly, use a subclass instead.')

    def setCost(self, cost):
        self.cost = cost

    def getCost(self):
        return self.cost

    def setQuantity(self, quantity):
        self.quantity = quantity

    def getQuantity(self):
        return self.quantity
