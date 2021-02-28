<?php

declare(strict_types=1);

namespace Tests;

define('__ROOT__', dirname(dirname(__FILE__)));
require_once __ROOT__.'/src/SpaceportDepartureBoard.php';
require_once __ROOT__.'/src/ISpacelineLaunchInfoProvider.php';
require_once __ROOT__.'/src/LaunchInfo.php';

use Spaceport\SpaceportDepartureBoard;
use Spaceport\ISpacelineLaunchInfoProvider;
use Spaceport\LaunchInfo;
use Spaceport\LaunchStatus;
use PHPUnit\Framework\TestCase;

class LaunchOrderListingTest extends TestCase
{
    public function testFrameworkRunsAndFails(): void
    {
        $this->assertSame(1, 0, 'Confirm framework setup reports this as a failing test');
    }

    public function testLaunchesAre_SortedByDestination_DestinationsAreUnique(): void
    {
        // Step 1. Create LaunchInfoProviderStub (that implements ISpacelineLaunchInfoProvider)

        // Step 2 & 3 & 4. Create SUT - SpaceportDepartureBoard, using Constructor Injection
        // Exercising this behavior happens during construction of the System Under Test

        // Step 5. Verify the results are sorted correctly

        $this->fail('TODO - test the sorting behavior');
    }
}
