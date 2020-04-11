package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {

    @Test
    public void this_test_needs_a_better_name() {
        // Arrange
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose sut = new GildedRose(items);

        // Act
        sut.updateQuality();

        // Assert
        assertEquals("fixme", sut.items[0].name);
    }
}
