using System;
using System.Collections.Generic;

namespace csharp
{
    public interface ISpacelineLaunchInfoProvider : IObservable<LaunchInfo>
    {
        List<LaunchInfo> GetCurrentLaunches();
    }
}