from abc import ABCMeta
from abc import abstractmethod

class AbstractRentable(object):
    __metaclass__ = ABCMeta
    
    @abstractmethod
    def getTotalCost(self):
        pass
