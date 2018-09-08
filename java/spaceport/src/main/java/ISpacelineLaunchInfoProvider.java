package main.java;

import java.util.List;

public interface ISpacelineLaunchInfoProvider {

    public List<LaunchInfo> getCurrentLaunches();

    void addListener(LaunchInfoChangedListener p);
    void removeListener(LaunchInfoChangedListener p);
}
