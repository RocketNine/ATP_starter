class SpaceportDepartureBoard():
    def __init__(self, SpacelineLaunchInfoProvider):
        self.launch_list = SpacelineLaunchInfoProvider.get_launch_list()
        self.sort_launches(self)

    def get_launch_list(self):
        return self.launch_list

    def sort_launches(self):
        # TODO - implement the sorting logic!
        pass


