using System.Collections.Generic;
using NUnit.Framework;


namespace GildedRose
{
    [TestFixture]
    public class GildedRoseTest
    {
        [Test]
        public void this_test_needs_a_better_name()
        {
            // Arrange
            IList<Item> items = new List<Item> { new Item { Name = "foo", SellIn = 0, Quality = 0 } };
            GildedRose sut = new GildedRose(items);
            
            // Act
            sut.UpdateQuality();
            
            // Assert
            Assert.AreEqual("fixme", items[0].Name);
        }
    }
}
