package com.gildedrose;

/**
 * Interface for all rules that update the items.
 */
public interface UpdateRule {

    int MIN_QUALITY = 0;
    int MAX_QUALITY = 50;

    /**
   * @param item To be updated item.
   */
  void update(Item item);
}
