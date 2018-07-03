import unittest
from Bike import Bike
import AbstractRentable
import Rental
from RentByHour import RentByHour
from RentByDay import RentByDay
from RentByWeek import RentByWeek
from CompositeFamilyPromotion import CompositeFamilyPromotion

class Company(object):
    def __init__(self):
        self.bikes = list()
        self.rents = list()
        self.rentedBikes = list()

    def addNewBike(self,aBike):
        self.bikes.append(aBike)

    def removeBike(self,aBike):
        self.bikes.remove(aBike)

    def assignFreeBikeToRental(self,aRental):
        aBike = self.bikes[0]
        self.rentedBikes.append([aBike,aRental])
        self.removeBike(aBike)

    def rentByHour(self,hours):
        rentable = RentByHour(hours)
        self.rents.append(rentable)
        self.assignFreeBikeToRental(rentable)

    def rentByDay(self,days):
        rentable = RentByDay(days)
        self.rents.append(rentable)
        self.assignFreeBikeToRental(rentable)

    def rentByWeek(self,weeks):
        rentable = RentByWeek(weeks)
        self.rents.append(rentable)
        self.assignFreeBikeToRental(rentable)

    def familyRental(self,promoRentals):
        rentable = CompositeFamilyPromotion()
        try:
            for rent in promoRentals:
                rentable.addRental(rent)
        except ValueError as e:
            print e.message
            return 0
        else:
            self.rents.append(rentable)
            return 1

    def getTotalRentals(self):
        total = 0
        for rent in self.rents:
            total = total + rent.getTotalCost()
        return total



class CompanyTest(unittest.TestCase):
    def test_RentByHour(self):
        company = Company()
        company.addNewBike(Bike("UTF-123"))
        company.addNewBike(Bike("UTF-124"))
        company.addNewBike(Bike("UTF-125"))
        company.addNewBike(Bike("UTF-126"))
        company.addNewBike(Bike("UTF-127"))
        company.rentByHour(1)
        self.assertEqual(company.getTotalRentals(),5)

    def test_RentByTwoHours(self):
        company = Company()
        company.addNewBike(Bike("UTF-123"))
        company.addNewBike(Bike("UTF-124"))
        company.addNewBike(Bike("UTF-125"))
        company.addNewBike(Bike("UTF-126"))
        company.addNewBike(Bike("UTF-127"))
        company.rentByHour(2)
        self.assertEqual(company.getTotalRentals(),10)

    def test_RentByFiveHours(self):
        company = Company()
        company.addNewBike(Bike("UTF-123"))
        company.addNewBike(Bike("UTF-124"))
        company.addNewBike(Bike("UTF-125"))
        company.addNewBike(Bike("UTF-126"))
        company.addNewBike(Bike("UTF-127"))
        company.rentByHour(5)
        self.assertEqual(company.getTotalRentals(),25)

    def test_RentByDay(self):
        company = Company()
        company.addNewBike(Bike("UTF-123"))
        company.addNewBike(Bike("UTF-124"))
        company.addNewBike(Bike("UTF-125"))
        company.addNewBike(Bike("UTF-126"))
        company.addNewBike(Bike("UTF-127"))
        company.rentByDay(1)
        self.assertEqual(company.getTotalRentals(),20)

    def test_RentByTwoDays(self):
        company = Company()
        company.addNewBike(Bike("UTF-123"))
        company.addNewBike(Bike("UTF-124"))
        company.addNewBike(Bike("UTF-125"))
        company.addNewBike(Bike("UTF-126"))
        company.addNewBike(Bike("UTF-127"))
        company.rentByDay(2)
        self.assertEqual(company.getTotalRentals(),40)

    def test_RentByFiveDays(self):
        company = Company()
        company.addNewBike(Bike("UTF-123"))
        company.addNewBike(Bike("UTF-124"))
        company.addNewBike(Bike("UTF-125"))
        company.addNewBike(Bike("UTF-126"))
        company.addNewBike(Bike("UTF-127"))
        company.rentByDay(5)
        self.assertEqual(company.getTotalRentals(),100)

    def test_RentByWeek(self):
        company = Company()
        company.addNewBike(Bike("UTF-123"))
        company.addNewBike(Bike("UTF-124"))
        company.addNewBike(Bike("UTF-125"))
        company.addNewBike(Bike("UTF-126"))
        company.addNewBike(Bike("UTF-127"))
        company.rentByWeek(1)
        self.assertEqual(company.getTotalRentals(),60)

    def test_RentByTwoWeeks(self):
        company = Company()
        company.addNewBike(Bike("UTF-123"))
        company.addNewBike(Bike("UTF-124"))
        company.addNewBike(Bike("UTF-125"))
        company.addNewBike(Bike("UTF-126"))
        company.addNewBike(Bike("UTF-127"))
        company.rentByWeek(2)
        self.assertEqual(company.getTotalRentals(),120)

    def test_RentByFiveWeeks(self):
        company = Company()
        company.addNewBike(Bike("UTF-123"))
        company.addNewBike(Bike("UTF-124"))
        company.addNewBike(Bike("UTF-125"))
        company.addNewBike(Bike("UTF-126"))
        company.addNewBike(Bike("UTF-127"))
        company.rentByWeek(5)
        self.assertEqual(company.getTotalRentals(),300)

    def test_FamiliRental(self):
        company = Company()
        company.addNewBike(Bike("UTF-123"))
        company.addNewBike(Bike("UTF-124"))
        company.addNewBike(Bike("UTF-125"))
        company.addNewBike(Bike("UTF-126"))
        company.addNewBike(Bike("UTF-127"))
        rentals = list()
        rentals.append(RentByHour(10))
        rentals.append(RentByDay(4))
        rentals.append(RentByWeek(2))
        rentals.append(RentByHour(8))
        rentals.append(RentByDay(1))
        company.familyRental(rentals)
        self.assertEqual(company.getTotalRentals(),310)


    def test_InvalidFamiliRentalByLessThanMin(self):
        company = Company()
        company.addNewBike(Bike("UTF-123"))
        company.addNewBike(Bike("UTF-124"))
        company.addNewBike(Bike("UTF-125"))
        company.addNewBike(Bike("UTF-126"))
        company.addNewBike(Bike("UTF-127"))
        rentals = list()
        rentals.append(RentByHour(10))
        rentals.append(RentByDay(4))
        if company.familyRental(rentals) == 1:
            self.assertEqual(company.getTotalRentals(),0)
        else:
            self.assertEqual(1,0)

    def test_InvalidFamiliRentalByMoreThanMax(self):
        company = Company()
        company.addNewBike(Bike("UTF-123"))
        company.addNewBike(Bike("UTF-124"))
        company.addNewBike(Bike("UTF-125"))
        company.addNewBike(Bike("UTF-126"))
        company.addNewBike(Bike("UTF-127"))
        company.addNewBike(Bike("UTF-128"))
        rentals = list()
        rentals.append(RentByHour(10))
        rentals.append(RentByDay(4))
        rentals.append(RentByWeek(2))
        rentals.append(RentByHour(8))
        rentals.append(RentByDay(1))
        rentals.append(RentByDay(4))
        company.familyRental(rentals)
        self.assertEqual(company.familyRental(rentals),0)

if __name__ == '__main__':
    unittest.main()
