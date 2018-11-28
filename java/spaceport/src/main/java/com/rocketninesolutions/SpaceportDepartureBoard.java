package com.rocketninesolutions;

import jdk.jshell.spi.ExecutionControl;

import java.util.Collections;
import java.util.List;

public class SpaceportDepartureBoard implements LaunchInfoChangedListener {

    private ISpacelineLaunchInfoProvider provider;
    private List<LaunchInfo> launchList;
    private boolean running;

    public SpaceportDepartureBoard(ISpacelineLaunchInfoProvider provider) {
        this.provider = provider;
        launchList = provider.getCurrentLaunches();
        sortLaunches();
        provider.addListener(this);
        running = true;
    }

    public List<LaunchInfo> getLaunchList() {
        return Collections.unmodifiableList(launchList);
    }

    @Override
    public void onLaunchInfoChanged(LaunchInfo launchInfo) {
        LaunchInfo.LaunchStatus status = launchInfo.getStatus();

        if (status == LaunchInfo.LaunchStatus.Delayed) {
            handleDelayedLaunch(launchInfo);
        } else if (status == LaunchInfo.LaunchStatus.Scrubbed) {
            handleScrubbedLaunch(launchInfo);
        } else if (status == LaunchInfo.LaunchStatus.Launched) {
            handleLaunched(launchInfo);
        } else {
            addNewLaunch(launchInfo);
        }
    }

    private void sortLaunches() {
        throw new UnsupportedOperationException("sorting logic hasn't been implemented yet");
    }

    private void addNewLaunch(LaunchInfo launchInfo) {
        launchList.add(launchInfo);
    }

    private void handleDelayedLaunch(LaunchInfo launchInfo) {
        throw new UnsupportedOperationException("delayed launches are not supported");
    }

    private void handleScrubbedLaunch(LaunchInfo launchInfo) {
        throw new UnsupportedOperationException("scrubbed launches are not supported");
    }

    private void handleLaunched(LaunchInfo launchInfo) {
        throw new UnsupportedOperationException("launched launches are not supported");
    }

    public void shutDown() {
        running = false;
    }
}
