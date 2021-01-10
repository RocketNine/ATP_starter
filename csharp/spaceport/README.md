# Spaceport Departures Board


Rocket 9 needs your team to finish up the code for our Spaceport Departures Board. Like a departures board at an airport the Spaceport Departures Board lists launch times of all spacecraft venturing to outer space. Our former team of contract Elbonian programmers left some code that you can build on (or scrap in favor of something more maintainable). 

The list of launches displayed on the board should be sorted by Destination. Each line on the departure board should show: Destination, Time, Launchpad, Flight Number, and Status. When multiple craft are flying to the same Destination then sort by departure Time. To avoid confusing the space tourists only display the hours and minutes portion of the Time.

When the Departures Board first starts it queries all partner Spacelines via a Spaceline Launch Info Provider to receive the current launch list. The list contains Launch Info objects (detailed below).

**TODO**: Create a Test Double that implements the SpacelineLaunchInfoProvider interface. Use dependency injection to use your Test Double when testing the Departures Board.

Launches remain on the board until they launch or are scrubbed. When a flight launches at the departure Time the Status is updated to “Launched”. 5 minutes after launch the entry is removed from the departures board.

Occasionally launches are scrubbed. The Status column is updated to “Scrubbed”. 10 minutes after the original departure Time the entry is removed from the departures board.

Whenever an entry is removed from the board the remaining entries “move up” so that there are no empty lines on the board.

When a flight is Delayed the new departure time is displayed in the Status column.

**TODO**: The Departures Board is an Listener of the Spaceline Launch Info Provider. When launch status changes the Provider calls the Departures Board’s onLaunchInfoChanged method to communicate the change. Your test can act in place of the Provider and call the onLaunchInfoChanged method directly in order to test the behavior.


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
