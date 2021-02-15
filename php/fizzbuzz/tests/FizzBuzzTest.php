<?php

declare(strict_types=1);

namespace Tests;

use PHPUnit\Framework\TestCase;

class FizzBuzzTest extends TestCase
{
    public function testVerifyTestFrameworkRuns(): void
    {
        $this->fail('A failing test confirms the test framework is running!');
    }
}