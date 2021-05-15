package com.gildedrose;

import static org.junit.jupiter.api.Assertions.*;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * @author Koert Zeilstra
 */
class AgedBrieUpdateTest {

  public static final String NAME = "Aged Brie";
  public static final Integer[] SELL_IN = {-1, 0, 4, 5, 6, 9, 10, 11};
  public static final Integer[] QUALITY = {0, 10, 50};

  AgedBrieUpdate update = new AgedBrieUpdate();

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