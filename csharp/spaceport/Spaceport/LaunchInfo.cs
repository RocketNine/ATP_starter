using System;

namespace csharp
{
    public class LaunchInfo
    {
        public enum LaunchStatus
        {
            Aok,
            Delayed,
            Scrubbed,
            Launched
        };
        
        public Guid LaunchID { get; set; }
        public string Destination { get; set; }
        public string FlightNumber { get; set; }
        public DateTime Time { get; set; }
        public string Launchpad { get; set; }
        public LaunchStatus Status { get; set; }
    }
}