using System;
using System.Collections.Generic;

namespace csharp
{
    public class SpaceportDepartureBoard : IObserver<LaunchInfo>
    {
        private ISpacelineLaunchInfoProvider provider;
        
        public List<LaunchInfo> LaunchList { get; }

        private Boolean running;
        
        public SpaceportDepartureBoard(ISpacelineLaunchInfoProvider provider)
        {
            this.provider = provider;
            LaunchList = provider.GetCurrentLaunches();
            provider.Subscribe(this);
            running = true;
        }

        public void OnNext(LaunchInfo info)
        {            
            if (info.Status == LaunchInfo.LaunchStatus.Delayed)
            {
                HandleDelayedLaunch();
            } else if (info.Status == LaunchInfo.LaunchStatus.Scrubbed)
            {
                HandleScrubbedLaunch();
            }
            else
            {
                AddNewLaunch(info);
            }
       }

        private void AddNewLaunch(LaunchInfo info)
        {
            LaunchList.Add(info);
        }

        private void HandleScrubbedLaunch()
        {
            throw new NotImplementedException();
        }

        private void HandleDelayedLaunch()
        {
            throw new NotImplementedException();
        }

        public void OnCompleted()
        {
            throw new NotImplementedException();
        }

        public void OnError(Exception error)
        {
            throw new NotImplementedException();
        }

        public void ShutDown()
        {
            running = false;
        }        
    }
}