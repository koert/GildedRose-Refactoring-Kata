package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

class GildedRoseOptimized {

    Item[] items;

    private Map<String, UpdateRule> updateRules = new HashMap<>();
    private UpdateRule otherItemRule = new OtherItemUpdate();

    public GildedRoseOptimized(Item[] items) {
        this.items = items;
        updateRules.put("Aged Brie", new AgedBrieUpdate());
        updateRules.put("Sulfuras, Hand of Ragnaros", new SulfurasUpdate());
        updateRules.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassUpdate());
        updateRules.put("Conjured", new ConjuredUpdate());
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

}