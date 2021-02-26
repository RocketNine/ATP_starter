using System;
using System.Collections.Generic;
using System.Threading;
using NUnit.Framework;

namespace SpacePort
{
    [TestFixture]
    public class LaunchedFlightsTest
    {
        // These tests attempt to show Launched flights are removed from the departure board
        // Since the SpaceBoardDepartureBoard is using the current time, via LocalDateTime.now()
        // these tests sometimes fail
        // TODO - introduce a mock for the clock to always test against a fixed time

        [Test]
        public void Launched_WellUnderWindowToRemove_Should_RemainInList()
        {
            DateTime fourMinutesAgo = DateTime.Now.Subtract(new TimeSpan(0, 0, 4, 0));
            LaunchInfo li = CreateLaunchInfoWithTime(fourMinutesAgo);

            MockLaunchInfoProvider mock = new MockLaunchInfoProvider();
            mock.LaunchList.Add(li);

            SpaceportDepartureBoard sut = new SpaceportDepartureBoard(mock);
            sut.RemoveInactiveLaunches();

            Assert.AreEqual(1, sut.LaunchList.Count,"Launched four minutes ago, should still be on the board");
        }

        [Test]
        public void Launched_OneSecondUnderWindowToRemove_Should_RemainInList()
        {
            DateTime almostFiveMinutesAgo = DateTime.Now.Subtract(new TimeSpan(0, 0, 4, 59));
            LaunchInfo li = CreateLaunchInfoWithTime(almostFiveMinutesAgo);

            MockLaunchInfoProvider mock = new MockLaunchInfoProvider();
            mock.LaunchList.Add(li);

            SpaceportDepartureBoard sut = new SpaceportDepartureBoard(mock);
            sut.RemoveInactiveLaunches();

            Assert.AreEqual(1, sut.LaunchList.Count, "Launched four minutes 59 seconds ago, should still be on the board");
        }

        [Test]
        [Repeat(1000)]
        public void Launched_LessThanOneSecondUnderWindowToRemove_Should_RemainInList()
        {
            DateTime almostFiveMinutesAgo = DateTime.Now.Subtract(new TimeSpan(0, 0, 5, 0)).AddMilliseconds(10);
            LaunchInfo li = CreateLaunchInfoWithTime(almostFiveMinutesAgo);
            
            MockLaunchInfoProvider mock = new MockLaunchInfoProvider();
            mock.LaunchList.Add(li);

            SpaceportDepartureBoard sut = new SpaceportDepartureBoard(mock);
            sut.RemoveInactiveLaunches();

            Assert.AreEqual(1, sut.LaunchList.Count, "Launched less than 5 minutes ago, should still be on the board");
        }
        
        [Test]
        public void Launched_ExactlyFiveMinutesAgo_ShouldNot_RemainInList()
        {
            DateTime exactlyFiveMinutesAgo = DateTime.Now.Subtract(new TimeSpan(0, 5, 0));
            LaunchInfo li = CreateLaunchInfoWithTime(exactlyFiveMinutesAgo);

            MockLaunchInfoProvider mock = new MockLaunchInfoProvider();
            mock.LaunchList.Add(li);

            SpaceportDepartureBoard sut = new SpaceportDepartureBoard(mock);
            sut.RemoveInactiveLaunches();

            Assert.AreEqual(0, sut.LaunchList.Count, "Launched 5 minutes ago, should be removed from list of launches");
        }
        
        private class MockLaunchInfoProvider: ISpacelineLaunchInfoProvider
        {
            private List<LaunchInfo> _launchList;

            public List<LaunchInfo> LaunchList
            {
                get => _launchList;
                set => _launchList = value;
            }

            public MockLaunchInfoProvider()
            {
                this._launchList = new List<LaunchInfo>();
                Thread.Sleep(10);   // causes enough delay to interfere with DateTime.Now 
            }
            
            public List<LaunchInfo> GetCurrentLaunches()
            {
                return _launchList;
            }
        }

        private LaunchInfo CreateLaunchInfoWithTime(DateTime time)
        {
            LaunchInfo launchInfo = new LaunchInfo(Guid.NewGuid());
            launchInfo.Status = LaunchInfo.LaunchStatus.Launched;
            launchInfo.Time = time;
            return launchInfo;
        }
    }
}