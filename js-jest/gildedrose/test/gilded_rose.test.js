const {Shop, Item} = require("../src/gilded_rose");

describe("Gilded Rose", function() {
  it("should DESCRIBE WHAT BEHAVIOR IS BEING CONFIRMED", function() {
    const gildedRose = new Shop([new Item("foo", 0, 0)]);
    const items = gildedRose.updateQuality();
    expect(items[0].name).toBe("fixme");
  });
});
