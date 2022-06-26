const {Shop, Item} = require("../src/gilded_rose");

describe("Gilded Rose", function() {
  it("should DESCRIBE WHAT BEHAVIOR IS BEING CONFIRMED", () => {
    // Arrange
    const sut = new Shop([new Item("foo", 0, 0)]);

    // Act
    const items = sut.updateQuality();

    // Assert
    expect(items[0].name).toBe("fixme");
  });
});
