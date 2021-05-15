package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Koert Zeilstra
 */
class OtherItemUpdateTest {

  public static final String NAME = "Some other item";
  public static final Integer[] SELL_IN = {-1, 0, 4, 5, 6, 9, 10, 11};
  public static final Integer[] QUALITY = {0, 10, 50};

  OtherItemUpdate update = new OtherItemUpdate();

  @DisplayName("update")
  @Test
  void update() {
    CombinationApprovals.verifyAllCombinations(this::doUpdateQuality, SELL_IN, QUALITY);
  }

  String doUpdateQuality(int sellIn, int quality) {
    Item item = new Item(NAME, sellIn, quality);    
    update.update(item);
    return item.toString();
  }

}