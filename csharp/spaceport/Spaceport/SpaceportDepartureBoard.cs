using System;
using System.Collections.Generic;

namespace SpacePort
{
    public class SpaceportDepartureBoard : IObserver<LaunchInfo>
    {
        private readonly ISpacelineLaunchInfoProvider _provider;
        
        public List<LaunchInfo> LaunchList { get; }

        private Boolean _running;
        
        public SpaceportDepartureBoard(ISpacelineLaunchInfoProvider provider)
        {
            _provider  = provider;
            LaunchList = _provider.GetCurrentLaunches();
            SortLaunches();
            _provider.Subscribe(this);
            _running = true;
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

        private void SortLaunches() {
            throw new NotImplementedException("sorting logic hasn't been implemented yet");
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
            _running = false;
        }        
    }
}