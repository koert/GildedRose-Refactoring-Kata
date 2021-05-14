package com.gildedrose;

/**
 * Aged Brie - always increases in quality - at sell or later, increases with 2 in quality
 */
public class AgedBrieUpdate implements UpdateRule {

  @Override
  public void update(Item item) {
    item.sellIn = item.sellIn - 1;
    if (item.sellIn < 0) {
      item.quality = Math.min(UpdateRule.MAX_QUALITY, item.quality + 2);
    } else {
      item.quality = Math.min(UpdateRule.MAX_QUALITY, item.quality + 1);
    }
  }
}
