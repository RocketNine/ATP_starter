from dataclasses import dataclass
import uuid
import datetime
from enum import Enum

class LaunchStatus(Enum):
    AOK = 1
    DELAYED = 2
    SCRUBBED = 3
    LAUNCHED = 4

@dataclass
class LaunchInfo:
    launch_id: uuid
    destination: str
    flight_number: str
    launch_time: datetime
    launchPad: str
    status: LaunchStatus

