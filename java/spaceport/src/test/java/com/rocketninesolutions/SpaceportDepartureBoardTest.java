package com.rocketninesolutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class SpaceportDepartureBoardTest {

    //TODO - Use the Stub Recipe to test that launches are sorted correctly
    @Test
    public void Launched_WithinWindow_StillPartOfDepartureBoard() {

        LaunchInfo launch1 = new LaunchInfo(UUID.randomUUID());
        launch1.setDestination("Mars");
        launch1.setStatus(LaunchInfo.LaunchStatus.Launched);
        launch1.setTime(LocalDateTime.now());

        MockProvider mock = new MockProvider();
        mock.addLaunch(launch1);

        SpaceportDepartureBoard sut = new SpaceportDepartureBoard(mock);
        sut.removeInactiveLaunches();

        Assertions.assertEquals(1, sut.getLaunchList().size());
    }

    @Test
    public void Scrubbed_WithinWindow_StillPartOfDepartureBoard() {

        LaunchInfo launch1 = new LaunchInfo(UUID.randomUUID());
        launch1.setDestination("Mars");
        launch1.setStatus(LaunchInfo.LaunchStatus.Scrubbed);
        launch1.setTime(LocalDateTime.now());

        MockProvider mock = new MockProvider();
        mock.addLaunch(launch1);

        SpaceportDepartureBoard sut = new SpaceportDepartureBoard(mock);
        sut.removeInactiveLaunches();

        Assertions.assertEquals(1, sut.getLaunchList().size());
    }

    @Test
    @Disabled
    public void Launched_PastWindow_NotPartOfDepartureBoard() {

        LaunchInfo launch1 = new LaunchInfo(UUID.randomUUID());
        launch1.setDestination("Mars");
        launch1.setStatus(LaunchInfo.LaunchStatus.Launched);
        launch1.setTime(LocalDateTime.now());

        MockProvider mock = new MockProvider();
        mock.addLaunch(launch1);

        SpaceportDepartureBoard sut = new SpaceportDepartureBoard(mock);

        // mock something that can return the current time

//        sut.setClock(mockClock);
        sut.removeInactiveLaunches();

        Assertions.assertEquals(0, sut.getLaunchList().size());

    }

    class MockProvider implements ISpacelineLaunchInfoProvider {

        private List<LaunchInfo> launches;

        public MockProvider() {
            this.launches = new ArrayList<>();
        }

        @Override
        public List<LaunchInfo> getCurrentLaunches() {
            return launches;
        }

        @Override
        public void addListener(LaunchInfoChangedListener p) {

        }

        @Override
        public void removeListener(LaunchInfoChangedListener p) {

        }

        public void addLaunch(LaunchInfo launch) {
            launches.add(launch);
        }
    }
}
