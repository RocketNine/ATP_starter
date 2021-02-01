using System;
using System.Collections.Generic;

namespace SpacePort
{
    public interface ISpacelineLaunchInfoProvider : IObservable<LaunchInfo>
    {
        List<LaunchInfo> GetCurrentLaunches();
    }
}