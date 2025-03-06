package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    @Test
    void testAgedBrie() {
        Item[] items = new Item[]{
                new AgedBrie("Aged Brie", 10, 40),
                new AgedBrie("Aged Brie", -1, 40)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(41, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(42, app.items[1].quality);
        assertEquals(-2, app.items[1].sellIn);
    }

    @Test
    void testAgedBrieSup50() {
        Item[] items = new Item[]{
                new AgedBrie("Aged Brie", 10, 50),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void testSulfuras() {
        Item[] items = new Item[]{
                new Sulfuras("Sulfuras, Hand of Ragnaros", 10, 80),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void testBackstage() {
        Item[] items = new Item[]{
                new Backstage("Backstage passes to a TAFKAL80ETC concert", 11, 42),
                new Backstage("Backstage passes to a TAFKAL80ETC concert", 10, 42),
                new Backstage("Backstage passes to a TAFKAL80ETC concert", 5, 42),
                new Backstage("Backstage passes to a TAFKAL80ETC concert", 0, 42),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(43, app.items[0].quality);
        assertEquals(10, app.items[0].sellIn);
        assertEquals(44, app.items[1].quality);
        assertEquals(9, app.items[1].sellIn);
        assertEquals(45, app.items[2].quality);
        assertEquals(4, app.items[2].sellIn);
        assertEquals(0, app.items[3].quality);
        assertEquals(-1, app.items[3].sellIn);
    }


    @Test
    void testBackstageSup50() {
        Item[] items = new Item[]{
                new Backstage("Backstage passes to a TAFKAL80ETC concert", 11, 50),
                new Backstage("Backstage passes to a TAFKAL80ETC concert", 10, 50),
                new Backstage("Backstage passes to a TAFKAL80ETC concert", 10, 49)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(50, app.items[1].quality);
        assertEquals(50, app.items[2].quality);
    }

    @Test
    void testLambda(){
        Item[] items = new Item[]{
                new Lambda("Test", 10, 0),
                new Lambda("Test", -1, 10),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(8, app.items[1].quality);
        assertEquals(-2, app.items[1].sellIn);
    }

}
