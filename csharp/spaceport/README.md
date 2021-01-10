# Spaceport Departures Board

Rocket 9 needs your team to finish up the code for our Spaceport Departures Board. Like a departures board at an airport the Spaceport Departures Board lists launch times of all spacecraft venturing to outer space. Our former team of contract Elbonian programmers left some code that you can build on (or scrap in favor of something more maintainable).

When the Departures Board first starts it queries all partner Spacelines via a Spaceline Launch Info Provider to receive the current launch list. That list contains Launch Info objects (detailed below).

The list of launches displayed on the board should be sorted by Destination. When multiple craft are flying to the same Destination then sort by departure Time.

**TODO:** Create a Test Double that implements the Spaceline Launch Info Provider interface. Use dependency injection to have your Departures Board behavior interact with a Test Double and verify the sorted order of the launches.

Launches remain on the board until they launch or are scrubbed. When a flight is launched the Departures Board is notified of the new status (“Launched”) and actual launch time. 5 minutes after launch that entry should no longer be displayed on the departures board.

Occasionally launches are scrubbed. The Departures Board is notified of the new status (“Scrubbed”) and the time. 10 minutes after being Scrubbed that entry is no longer displayed on the departures board.

**TODO:** Removal of launches from the Departures Board happens in the RemoveInactiveLaunchess method. Launches that are Launched or Scrubbed but within their active window will remain part of the Departures Board list. Once past the active window they are removed from the Departures Board list. You will need to introduce a Test Double for the clock!

    public class LaunchInfo {

        private UUID launchID;
        private String destination;
        private String flightNumber;
        private LocalDateTime time;
        private String launchPad;
        private LaunchStatus status;

        public enum LaunchStatus {
            Aok, Delayed, Scrubbed, Launched
        };
    }
