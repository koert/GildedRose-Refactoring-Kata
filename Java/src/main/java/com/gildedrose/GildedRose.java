package com.gildedrose;

import java.util.ArrayList;
import java.util.List;

class GildedRose {
    public static final int MAX_QUALITY = 50;

    Item[] items;

    private List<UpdateRule> updateRules = new ArrayList<>();

    public GildedRose(Item[] items) {
        this.items = items;
        updateRules.add(new AgedBrie());
        updateRules.add(new Sulfuras());
        updateRules.add(new BackstagePass());
        updateRules.add(new Conjured());
        updateRules.add(new OtherItem());
    }

    public void updateQuality() {
        for (Item item : items) {
            boolean itemUpdateDone = false;
            for (int ruleIndex = 0; ruleIndex < updateRules.size() && !itemUpdateDone; ruleIndex++) {
                UpdateRule rule = updateRules.get(ruleIndex);
                itemUpdateDone = rule.update(item);
            }
        }
    }

    /**
     * Interface for all rules that update the items.
     */
    public interface UpdateRule {

        /**
         * @param item To be updated item.
         * @return True if item was updated.
         */
        boolean update(Item item);
    }

    /**
     * Aged Brie
     * - always increases in quality
     * - at sell or later, increases with 2 in quality
     */
    public static class AgedBrie implements UpdateRule {
        @Override
        public boolean update(Item item) {
            if (item.name.equals("Aged Brie")) {
                item.sellIn = item.sellIn - 1;
                if (item.sellIn < 0) {
                    item.quality = Math.min(MAX_QUALITY, item.quality + 2);
                } else {
                    item.quality = Math.min(MAX_QUALITY, item.quality + 1);
                }
                return true;
            }
            return false;
        }
    }

    /**
     * Sulfuras, Hand of Ragnaros.
     * - nothing changes
     */
    public static class Sulfuras implements UpdateRule {
        @Override
        public boolean update(Item item) {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                return true;
            }
            return false;
        }
    }

    /**
     * Backstage passes to a TAFKAL80ETC concert.
     */
    public static class BackstagePass implements UpdateRule {
        @Override
        public boolean update(Item item) {
            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                item.sellIn = item.sellIn - 1;
                if (item.sellIn < 0) {
                    item.quality = 0;
                } else if (item.sellIn < 6) {
                    item.quality = Math.min(MAX_QUALITY, item.quality + 3);
                } else if (item.sellIn < 11) {
                    item.quality = Math.min(MAX_QUALITY, item.quality + 2);
                } else {
                    item.quality = Math.min(MAX_QUALITY, item.quality + 1);
                }
                return true;
            }
            return false;
        }
    }

    /**
     * Conjured.
     */
    public static class Conjured implements UpdateRule {
        @Override
        public boolean update(Item item) {
            if (item.name.equals("Conjured")) {
                item.sellIn = item.sellIn - 1;
                if (item.sellIn < 0) {
                    item.quality = Math.max(0, item.quality - 4);
                } else {
                    item.quality = Math.max(0, item.quality - 2);
                }
                return true;
            }
            return false;
        }
    }

    /**
     * Update for all other items
     */
    public static class OtherItem implements UpdateRule {
        @Override
        public boolean update(Item item) {
            item.sellIn = item.sellIn - 1;
            if (item.sellIn < 0) {
                item.quality = Math.max(0, item.quality - 2);
            } else {
                item.quality = Math.max(0, item.quality - 1);
            }
            return true;
        }
    }

}