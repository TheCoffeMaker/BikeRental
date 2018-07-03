import unittest

class Bike(object):
    def __init__(self, plate):
        self.plate = plate

    def toString(self):
        return "Bike [plate= " + self.plate + "]"

    def getPlate(self):
        return self.plate

    def setPlate(self, plate):
        self.plate = plate

class BikeTest(unittest.TestCase):
    def test_creation(self):
        aBike = Bike("UTF-123")
        self.assertEqual(aBike.getPlate(),"UTF-123")

    def test_setget(self):
        aBike = Bike("")
        aBike.setPlate("UTF-123")
        self.assertEqual(aBike.getPlate(),"UTF-123")

if __name__ == '__main__':
    unittest.main()
