package com.gildedrose;

/**
 * Conjured.
 */
public class ConjuredUpdate implements UpdateRule {

  @Override
  public void update(Item item) {
    item.sellIn = item.sellIn - 1;
    if (item.sellIn < 0) {
      item.quality = Math.max(UpdateRule.MIN_QUALITY, item.quality - 4);
    } else {
      item.quality = Math.max(UpdateRule.MIN_QUALITY, item.quality - 2);
    }
  }
}
