<?php

declare(strict_types=1);

namespace Spaceport;

class LaunchInfo
{
    protected $_uuid;
    protected $_destination;
    protected $_flight_number;
    protected $_time;
    protected $_launch_pad;
    protected $_status;

    /**
     * LaunchInfo constructor.
     * @param $_uuid
     */
    public function __construct($_uuid)
    {
        $this->_uuid = $_uuid;
    }

    /**
     * @return string
     */
    public function getDestination(): string
    {
        return $this->_destination;
    }

    /**
     * @param string $destination
     * @return LaunchInfo
     */
    public function setDestination(string $destination): LaunchInfo
    {
        $this->_destination = $destination;
        return $this;
    }

    /**
     * @return string
     */
    public function getFlightNumber(): string
    {
        return $this->_flight_number;
    }

    /**
     * @param string $flight_number
     * @return LaunchInfo
     */
    public function setFlightNumber(string $flight_number): LaunchInfo
    {
        $this->_flight_number = $flight_number;
        return $this;
    }

    /**
     * @return DateTime
     */
    public function getTime(): DateTime
    {
        return $this->_time;
    }

    /**
     * @param DateTime $time
     * @return LaunchInfo
     */
    public function setTime(DateTime $time): LaunchInfo
    {
        $this->_time = $time;
        return $this;
    }

    /**
     * @return string
     */
    public function getLaunchPad(): string
    {
        return $this->_launch_pad;
    }

    /**
     * @param string $launch_pad
     * @return LaunchInfo
     */
    public function setLaunchPad(string $launch_pad): LaunchInfo
    {
        $this->_launch_pad = $launch_pad;
        return $this;
    }

    /**
     * @return LaunchStatus
     */
    public function getStatus(): LaunchStatus
    {
        return $this->_status;
    }

    /**
     * @param LaunchStatus $status
     * @return LaunchInfo
     */
    public function setStatus(LaunchStatus $status): LaunchInfo
    {
        $this->_status = $status;
        return $this;
    }

}

interface LaunchStatus
{
    const Aok = 0;
    const Delayed = 1;
    const Scrubbed = 2;
    const Launched = 3;
}
