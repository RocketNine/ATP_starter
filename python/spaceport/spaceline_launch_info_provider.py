from abc import ABC, abstractmethod

class SpacelineLaunchInfoProvider(ABC):
    @abstractmethod
    def get_current_launches(self):
        pass