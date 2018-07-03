from AbstractRentable import AbstractRentable
import unittest
from RentByDay import RentByDay

class CompositeFamilyPromotion(AbstractRentable):
    def __init__(self):
        self.minPromos = 3
        self.maxPromos = 5
        self.discount = 30
        self.promoRentals = list()

    def getTotalCost(self):
        if len(self.promoRentals)<self.minPromos:
            return 0

        promoSums = 0
        for rental in self.promoRentals:
            promoSums = promoSums + rental.getTotalCost()
        return promoSums

    def addRental(self, aRental):
        if len(self.promoRentals)<self.maxPromos:
            self.promoRentals.append(aRental)
        else:
            raise ValueError('Maximum rental items reached')

class CompositeFamilyPromotionTest(unittest.TestCase):
    def test_addRentalAndTotalCost(self):
        promo = CompositeFamilyPromotion()
        rental = RentByDay(1)
        promo.addRental(rental)
        rental = RentByDay(1)
        promo.addRental(rental)
        rental = RentByDay(1)
        promo.addRental(rental)
        rental = RentByDay(1)
        promo.addRental(rental)
        self.assertEqual(promo.getTotalCost(),80)


    def test_getTotalCostWhenLessThanMin(self):
        promo = CompositeFamilyPromotion()
        rental = RentByDay(1)
        promo.addRental(rental)
        self.assertEqual(promo.getTotalCost(),0)


if __name__ == '__main__':
    unittest.main()
