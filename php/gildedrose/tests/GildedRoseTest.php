<?php

declare(strict_types=1);

namespace Tests;

define('__ROOT__', dirname(dirname(__FILE__)));
require_once __ROOT__.'/src/GildedRose.php';
require_once __ROOT__.'/src/Item.php';

use GildedRose\GildedRose;
use GildedRose\Item;
use PHPUnit\Framework\TestCase;

class GildedRoseTest extends TestCase
{
    public function testItemName_DoesNotChange(): void
    {
        //Arrange
        $items = [new Item('foo', 0, 0)];
        $sut = new GildedRose($items);

        //Act
        $sut->updateQuality();

        //Assert
        $this->assertSame('fixme', $items[0]->name);
    }
}
