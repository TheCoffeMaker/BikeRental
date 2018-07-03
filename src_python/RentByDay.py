from Rental import Rental
import unittest

class RentByDay(Rental):
    def __init__(self, quantity):
        self.setCost(20)
        self.setQuantity(quantity)

    def getTotalCost(self):
        return self.getCost() * self.getQuantity()

class RentByDayTest(unittest.TestCase):
    def test_creation(self):
        aRent = RentByDay(2)
        self.assertEqual(aRent.getQuantity(),2)

    def test_setget(self):
        aRent = RentByDay(2)
        aRent.setQuantity(3)
        self.assertEqual(aRent.getQuantity()*aRent.getCost(),60)

    def test_totalcost(self):
        aRent = RentByDay(2)
        self.assertEqual(aRent.getTotalCost(),40)


if __name__ == '__main__':
    unittest.main()
