package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GildedRoseOptimizedTest {

    @Test
    void foo() {
        Item[] items = new Item[] {
            new Item("foo", -1, 0),
            new Item("foo", -1, 10),
            new Item("foo", 0, 10),
            new Item("foo", 10, 10)
        };
        GildedRoseOptimized app = new GildedRoseOptimized(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(8, app.items[1].quality);
        assertEquals(8, app.items[2].quality);
        assertEquals(9, app.items[3].quality);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(-2, app.items[1].sellIn);
        assertEquals(-1, app.items[2].sellIn);
        assertEquals(9, app.items[3].sellIn);
    }

    @Test
    void agedBrie() {
        Item[] items = new Item[] {
            new Item("Aged Brie", -1, 0),
            new Item("Aged Brie", 0, 0),
            new Item("Aged Brie", 10, 0),
            new Item("Aged Brie", 10, 50)
        };
        GildedRoseOptimized app = new GildedRoseOptimized(items);
        app.updateQuality();
        
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(2, app.items[0].quality);
        assertEquals(2, app.items[1].quality);
        assertEquals(1, app.items[2].quality);
        assertEquals(50, app.items[3].quality);
    }

    @Test
    void backstagePasses() {
        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10),
            new Item("Backstage passes to a TAFKAL80ETC concert", 20, 10),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10)
        };
        GildedRoseOptimized app = new GildedRoseOptimized(items);
        app.updateQuality();
        
        assertEquals(0, app.items[0].quality);
        assertEquals(13, app.items[1].quality);
        assertEquals(11, app.items[2].quality);
        assertEquals(12, app.items[3].quality);
    }

    @Test
    void sulfuras() {
        Item[] items = new Item[] {
            new Item("Sulfuras, Hand of Ragnaros", 0, 10),
            new Item("Sulfuras, Hand of Ragnaros", 20, 10),
            new Item("Sulfuras, Hand of Ragnaros", 10, 10)
        };
        GildedRoseOptimized app = new GildedRoseOptimized(items);
        app.updateQuality();
        
        assertEquals(10, app.items[0].quality);
        assertEquals(10, app.items[1].quality);
        assertEquals(10, app.items[2].quality);
    }

    @Test
    void conjured() {
        Item[] items = new Item[] {
            new Item("Conjured", -1, 0),
            new Item("Conjured", -1, 10),
            new Item("Conjured", 0, 10),
            new Item("Conjured", 10, 10)
        };
        GildedRoseOptimized app = new GildedRoseOptimized(items);
        app.updateQuality();
        assertEquals("Conjured", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(6, app.items[1].quality);
        assertEquals(6, app.items[2].quality);
        assertEquals(8, app.items[3].quality);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(-2, app.items[1].sellIn);
        assertEquals(-1, app.items[2].sellIn);
        assertEquals(9, app.items[3].sellIn);
    }

}
