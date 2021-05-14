package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GildedRoseOriginalTest {

    public static final String[] NAMES = {"foo", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert",
        "Sulfuras, Hand of Ragnaros", "Conjured"};
    public static final Integer[] SELL_IN = {-1, 0, 4, 5, 6, 9, 10, 11};
    public static final Integer[] QUALITY = {0, 10, 50};

    @DisplayName("updateQuality")
    @Test
    void updateQuality() {
        CombinationApprovals.verifyAllCombinations(this::doUpdateQuality, NAMES, SELL_IN, QUALITY);
    }
    
    String doUpdateQuality(String name, int sellIn, int quality) {
        Item[] items = new Item[] {
            new Item(name, sellIn, quality)
        };
        GildedRoseOriginal app = new GildedRoseOriginal(items);
        app.updateQuality();

        return app.items[0].toString();
    }

    @DisplayName("item name")
    @Nested class Name {
        @DisplayName("item name")
        @ParameterizedTest
        @CsvSource({"foo", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros", "Conjured"})
        void name(String name) {
            Item[] items = new Item[] {
                new Item(name, 0, 0)
            };
            GildedRoseOriginal app = new GildedRoseOriginal(items);
            app.updateQuality();

            assertEquals(name, app.items[0].name);
        }
    }

    @DisplayName("sellIn")
    @Nested class sellIn {
        @ParameterizedTest
        @CsvSource({"foo,-1", "foo,0", "foo,10", "Aged Brie,-1", "Aged Brie,0", "Aged Brie,1"})
        void name(String name, int sellIn) {
            Item[] items = new Item[] {
                new Item(name, sellIn, 0)
            };
            GildedRoseOriginal app = new GildedRoseOriginal(items);
            app.updateQuality();

            assertEquals(sellIn - 1, app.items[0].sellIn);
        }
    }

    @DisplayName("Aged Brie")
    @Nested class AgedBrie {
        @ParameterizedTest
        @CsvSource({"-1,0,2", "0,0,2", "10,0,1", "10,50,50"})
        void parameters(int sellIn, int quality, int expectedQuality) {
            Item[] items = new Item[] {
                new Item("Aged Brie", sellIn, quality)
            };
            GildedRoseOriginal app = new GildedRoseOriginal(items);
            app.updateQuality();

            assertEquals(expectedQuality, app.items[0].quality);
        }
    }

    @DisplayName("Backstage passes")
    @Nested class BackstagePass {
        @ParameterizedTest
        @CsvSource({"0,10,0", "4,10,13", "5,10,13", "6,10,12", "9,10,12", "10,10,12", "11,10,11", "20,10,11"})
        void parameters(int sellIn, int quality, int expectedQuality) {
            Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality)
            };
            GildedRoseOriginal app = new GildedRoseOriginal(items);
            app.updateQuality();

            assertEquals(expectedQuality, app.items[0].quality);
        }
    }

    @DisplayName("Sulfuras")
    @Nested class Sulfuras {
        @ParameterizedTest
        @CsvSource({"0,10,10", "20,10,10", "10,10,10"})
        void parameters(int sellIn, int quality, int expectedQuality) {
            Item[] items = new Item[] {
                new Item("Sulfuras, Hand of Ragnaros", sellIn, quality)
            };
            GildedRoseOriginal app = new GildedRoseOriginal(items);
            app.updateQuality();

            assertEquals(expectedQuality, app.items[0].quality);
        }
    }

}
