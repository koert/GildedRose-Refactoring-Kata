package com.gildedrose;

/**
 * Backstage passes to a TAFKAL80ETC concert.
 */
public class BackstagePassUpdate implements UpdateRule {

  @Override
  public void update(Item item) {
    item.sellIn = item.sellIn - 1;
    if (item.sellIn < 0) {
      item.quality = UpdateRule.MIN_QUALITY;
    } else if (item.sellIn < 5) {
      item.quality = Math.min(UpdateRule.MAX_QUALITY, item.quality + 3);
    } else if (item.sellIn < 10) {
      item.quality = Math.min(UpdateRule.MAX_QUALITY, item.quality + 2);
    } else {
      item.quality = Math.min(UpdateRule.MAX_QUALITY, item.quality + 1);
    }
  }
}
