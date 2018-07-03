from Rental import Rental
import unittest

class RentByWeek(Rental):
    def __init__(self, quantity):
        self.setCost(60)
        self.setQuantity(quantity)

    def getTotalCost(self):
        return self.getCost() * self.getQuantity()

class RentByWeekTest(unittest.TestCase):
    def test_creation(self):
        aRent = RentByWeek(2)
        self.assertEqual(aRent.getQuantity(),2)

    def test_setget(self):
        aRent = RentByWeek(2)
        aRent.setQuantity(3)
        self.assertEqual(aRent.getQuantity()*aRent.getCost(),180)

    def test_totalcost(self):
        aRent = RentByWeek(2)
        self.assertEqual(aRent.getTotalCost(),120)


if __name__ == '__main__':
    unittest.main()
