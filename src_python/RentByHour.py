from Rental import Rental
import unittest

class RentByHour(Rental):
    def __init__(self, quantity):
        self.setCost(5)
        self.setQuantity(quantity)

    def getTotalCost(self):
        return self.getCost() * self.getQuantity()

class RentByHourTest(unittest.TestCase):
    def test_creation(self):
        aRent = RentByHour(2)
        self.assertEqual(aRent.getQuantity(),2)

    def test_setget(self):
        aRent = RentByHour(2)
        aRent.setQuantity(3)
        self.assertEqual(aRent.getQuantity()*aRent.getCost(),15)

    def test_totalcost(self):
        aRent = RentByHour(2)
        self.assertEqual(aRent.getTotalCost(),10)


if __name__ == '__main__':
    unittest.main()
