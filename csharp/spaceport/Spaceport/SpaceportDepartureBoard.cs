using System;
using System.Collections.Generic;

namespace SpacePort
{
    public class SpaceportDepartureBoard
    {
        public List<LaunchInfo> LaunchList { get; }
        
        public SpaceportDepartureBoard(ISpacelineLaunchInfoProvider provider)
        {
            LaunchList = provider.GetCurrentLaunches();
            SortLaunches();
        }

        private void SortLaunches() {
            throw new NotImplementedException("sorting logic hasn't been implemented yet");
        }

        internal void RemoveInactiveLaunches()
        {
            DateTime now = DateTime.Now;

            for (int i = LaunchList.Count - 1; i >= 0; i-- )
            {
                LaunchInfo launchInfo = LaunchList[i];
                if (launchInfo.Status == LaunchInfo.LaunchStatus.Launched)
                {
                    if (launchInfo.Time.AddMinutes(5).CompareTo(now) <= 0) {
                        LaunchList.RemoveAt(i);
                    }
                } else if (launchInfo.Status == LaunchInfo.LaunchStatus.Scrubbed)
                {
                    if (launchInfo.Time.AddMinutes(10).CompareTo(now) <= 0)
                    {
                        LaunchList.RemoveAt(i);
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