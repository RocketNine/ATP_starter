<?php

declare(strict_types=1);

namespace Spaceport;

interface ISpacelineLaunchInfoProvider
{
    public function getCurrentLaunches(): array;
}