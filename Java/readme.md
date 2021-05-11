# Readme

# Unit tests

* Added more unit tests to get 100% coverage

# Refactoring

* System uses several rules to update items
* Created UpdateRule interface, put logic of update rules in implementations of this interface
    * These update rules update the item for one type only, no stacked or complicated updates
    * The rules are in a list
* The updateQuality() method runs through the rules, if rule matches, it will skip the rest of the rules

# Optimization
After doing the first refactoring, it could be optimized, because it basically finds a matching rule by looping through the
rules - it would be better to setup a Map to find the correct rule based on the type of the item.

Right now, it has only 4 different types, so the optimization is minimal, but if more types will be added, this
optimization will be more noticable.

The optimization is implemented in GildedRoseOptimized.



