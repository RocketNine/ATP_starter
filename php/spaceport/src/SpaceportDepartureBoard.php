<?php

declare(strict_types=1);

namespace Spaceport;

use Exception;

class SpaceportDepartureBoard
{
    private $launch_list = [];

    /**
     * SpaceportDepartureBoard constructor.
     * @param ISpacelineLaunchInfoProvider
     */
    public function __construct(ISpacelineLaunchInfoProvider $provider)
    {
        $this->launch_list = $provider->getCurrentLaunches();
        $this->sortLaunches();
    }

    /**
     * @return array
     */
    public function getLaunchList(): array
    {
        return $this->launch_list;
    }

    private function sortLaunches()
    {
        throw new Exception('TODO - implement the sorting logic for the Spaceport Departure Board');
    }
}