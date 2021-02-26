package com.rocketninesolutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LaunchedFlightsTest {

    // These tests attempt to show Launched flights are removed from the departure board
    // Since the SpaceBoardDepartureBoard is using the current time, via LocalDateTime.now()
    // these tests sometimes fail
    // TODO - introduce a mock for the clock to always test against a fixed time

    @Test
    public void launched_WellUnderWindowToRemove_Should_RemainInList() {
        LocalDateTime fourMinutesAgo = LocalDateTime.now().minusMinutes(4);
        LaunchInfo li = createLaunchedInfoWithTime(fourMinutesAgo);

        MockLaunchInfoProvider mock = new MockLaunchInfoProvider();
        mock.launchList.add(li);

        SpaceportDepartureBoard sut = new SpaceportDepartureBoard(mock);
        sut.removeInactiveLaunches();

        Assertions.assertEquals(1, sut.getLaunchList().size(), "Launched four minutes ago, still be on the board");
    }

    @Test
    public void launched_OneSecondUnderWindowToRemove_Should_RemainInList() {
        LocalDateTime almostFiveMinutesAgo = LocalDateTime.now().minusMinutes(5).plusSeconds(1);
        LaunchInfo li = createLaunchedInfoWithTime(almostFiveMinutesAgo);

        MockLaunchInfoProvider mock = new MockLaunchInfoProvider();
        mock.launchList.add(li);

        SpaceportDepartureBoard sut = new SpaceportDepartureBoard(mock);
        sut.removeInactiveLaunches();

        Assertions.assertEquals(1, sut.getLaunchList().size(), "Launch four minutes 59 seconds ago, should still be on the board");
    }

    @RepeatedTest(1000)
    public void launched_LessThanOneSecondUnderWindowToRemove_Should_RemainInList() {
        LocalDateTime almostFiveMinutesAgo = LocalDateTime.now().minusMinutes(5).plusNanos(50000);
        LaunchInfo li = createLaunchedInfoWithTime(almostFiveMinutesAgo);

        MockLaunchInfoProvider mock = new MockLaunchInfoProvider();
        mock.launchList.add(li);

        SpaceportDepartureBoard sut = new SpaceportDepartureBoard(mock);
        sut.removeInactiveLaunches();

        Assertions.assertEquals(1, sut.getLaunchList().size(), "Launched less than 5 minutes ago, should always appear in the list");
    }

    @Test
    public void launched_ExactlyFiveMinutesAgo_ShouldNot_RemainInList() {
        LocalDateTime exactlyFiveMinutesAgo = LocalDateTime.now().minusMinutes(5);
        LaunchInfo li = createLaunchedInfoWithTime(exactlyFiveMinutesAgo);

        MockLaunchInfoProvider mock = new MockLaunchInfoProvider();
        mock.launchList.add(li);

        SpaceportDepartureBoard sut = new SpaceportDepartureBoard(mock);
        sut.removeInactiveLaunches();

        Assertions.assertEquals(0, sut.getLaunchList().size(), "Launched 5 minutes ago, should be removed from list of launches");
    }



    private LaunchInfo createLaunchedInfoWithTime(LocalDateTime launchTime) {
        LaunchInfo li = new LaunchInfo(UUID.randomUUID());
        li.setStatus(LaunchInfo.LaunchStatus.Launched);
        li.setTime(launchTime);
        return li;
    }

    class MockLaunchInfoProvider implements ISpacelineLaunchInfoProvider {

        List<LaunchInfo> launchList;

        public MockLaunchInfoProvider() {
            this.launchList = new ArrayList<>();
        }

        @Override
        public List<LaunchInfo> getCurrentLaunches() {
            return launchList;
        }
    }
}
