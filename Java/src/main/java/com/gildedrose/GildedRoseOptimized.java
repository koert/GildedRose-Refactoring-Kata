package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

class GildedRoseOptimized {
    public static final int MAX_QUALITY = 50;

    Item[] items;

    private Map<String, UpdateRule> updateRules = new HashMap<>();
    private UpdateRule otherItemRule = new OtherItem();

    public GildedRoseOptimized(Item[] items) {
        this.items = items;
        updateRules.put("Aged Brie", new AgedBrie());
        updateRules.put("Sulfuras, Hand of Ragnaros", new Sulfuras());
        updateRules.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePass());
        updateRules.put("Conjured", new Conjured());
    }

    public void updateQuality() {
        for (Item item : items) {
            if (updateRules.containsKey(item.name)) {
                updateRules.get(item.name).update(item);
            } else {
                otherItemRule.update(item);
            }
        }
    }

    /**
     * Interface for all rules that update the items.
     */
    public interface UpdateRule {

        /**
         * @param item To be updated item.
         */
        void update(Item item);
    }

    /**
     * Aged Brie
     * - always increases in quality
     * - at sell or later, increases with 2 in quality
     */
    public static class AgedBrie implements UpdateRule {
        @Override
        public void update(Item item) {
            item.sellIn = item.sellIn - 1;
            if (item.sellIn < 0) {
                item.quality = Math.min(MAX_QUALITY, item.quality + 2);
            } else {
                item.quality = Math.min(MAX_QUALITY, item.quality + 1);
            }
        }
    }

    /**
     * Sulfuras, Hand of Ragnaros.
     * - nothing changes
     */
    public static class Sulfuras implements UpdateRule {
        @Override
        public void update(Item item) {
        }
    }

    /**
     * Backstage passes to a TAFKAL80ETC concert.
     */
    public static class BackstagePass implements UpdateRule {
        @Override
        public void update(Item item) {
            item.sellIn = item.sellIn - 1;
            if (item.sellIn < 0) {
                item.quality = 0;
            } else if (item.sellIn < 5) {
                item.quality = Math.min(MAX_QUALITY, item.quality + 3);
            } else if (item.sellIn < 10) {
                item.quality = Math.min(MAX_QUALITY, item.quality + 2);
            } else {
                item.quality = Math.min(MAX_QUALITY, item.quality + 1);
            }
        }
    }

    /**
     * Conjured.
     */
    public static class Conjured implements UpdateRule {
        @Override
        public void update(Item item) {
            item.sellIn = item.sellIn - 1;
            if (item.sellIn < 0) {
                item.quality = Math.max(0, item.quality - 4);
            } else {
                item.quality = Math.max(0, item.quality - 2);
            }
        }
    }

    /**
     * Update for all other items
     */
    public static class OtherItem implements UpdateRule {
        @Override
        public void update(Item item) {
            item.sellIn = item.sellIn - 1;
            if (item.sellIn < 0) {
                item.quality = Math.max(0, item.quality - 2);
            } else {
                item.quality = Math.max(0, item.quality - 1);
            }
        }
    }

}