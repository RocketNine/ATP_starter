using System;
using System.Collections.Generic;

namespace SpacePort
{
    public class SpaceportDepartureBoard
    {
        private readonly ISpacelineLaunchInfoProvider _provider;
        
        public List<LaunchInfo> LaunchList { get; }
        
        public SpaceportDepartureBoard(ISpacelineLaunchInfoProvider provider)
        {
            _provider  = provider;
            LaunchList = _provider.GetCurrentLaunches();
            SortLaunches();
        }

        private void SortLaunches() {
            throw new NotImplementedException("sorting logic hasn't been implemented yet");
        }

        protected void removeInactiveLaunches()
        {
            DateTime now = DateTime.Now;

            foreach (LaunchInfo launchInfo in LaunchList)
            {
                if (launchInfo.Status == LaunchInfo.LaunchStatus.Launched)
                {
                    if (launchInfo.Time.AddMinutes(5).CompareTo(now) <= 0) {
                        LaunchList.Remove(launchInfo);
                    }
                } else if (launchInfo.Status == LaunchInfo.LaunchStatus.Scrubbed)
                {
                    if (launchInfo.Time.AddMinutes(10).CompareTo(now) <= 0) {
                        LaunchList.Remove(launchInfo);
                    }
                }
            }
        }
        
        public void OnLaunchInfoChanged(LaunchInfo info)
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
    }
}