package com.gildedrose;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void AgedBrie_Quality_increases_by_one_before_sellby() {
        // Arrange
        Item[] items = new Item[] { new Item("Aged Brie", 1, 20) };
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(21, app.items[0].quality);
    }

    @Test
    public void AgedBrie_Quality_increases_by_two_after_sellby() {
        // Arrange
        Item[] items = new Item[] { new Item("Aged Brie", -1, 20) };
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(22, app.items[0].quality);
    }

    @Test
    public void Quality_Degrades_Twice_As_Fast_Past_SellByDate() {
        // Arrange
        Item[] items = new Item[] { new Item("ignored", -1, 10) };
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(8, app.items[0].quality);

    }

    @Test
    public void Quality_Never_Negative() {
        // Arrange
        Item[] items = new Item[] { new Item("ignored", -1, 0) };
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(0, app.items[0].quality);



    }

    @Test
    public void Quality_Never_Exceeds_50() {
        // Arrange
        Item[] items = new Item[] { new Item("Aged Brie", 10, 50) };
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(50, app.items[0].quality);

    }

    @Test
    public void Sulfuras_Never_Decreases_In_Quality() {
        // Arrange
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 80) };
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(80, app.items[0].quality);

    }

    @Test
    public void Sulfuras_Sellin_Equals_0() {
        // Arrange
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 80) };
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(1, app.items[0].sellIn);

    }

    @Test
    public void Backstage_Passes_Quality_Increases_By_2_Between_SellIn_10_and_5() {
        // Arrange
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 7, 5) };
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(7, app.items[0].quality);

    }

    @Test
    public void Backstage_Passes_Quality_Increases_By_3_Between_SellIn_5_and_0() {
        // Arrange
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 3, 5) };
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(8, app.items[0].quality);

    }

    @Test
    public void Backstage_Passes_Equals_Zero_After_SellIn() {
        // Arrange
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -3, 5) };
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(0, app.items[0].quality);

    }

}
