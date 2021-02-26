using System.Collections.Generic;

namespace SpacePort
{
    public interface ISpacelineLaunchInfoProvider
    {
        List<LaunchInfo> GetCurrentLaunches();
    }
}