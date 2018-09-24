using System.Collections.Generic;
using NUnit.Framework;


namespace csharp
{
    [TestFixture]
    public class GildedRoseTest
    {
        [Test]
        public void this_test_needs_a_better_name()
        {
            // Arrange
            IList<Item> Items = new List<Item> { new Item { Name = "foo", SellIn = 0, Quality = 0 } };
            GildedRose sut = new GildedRose(Items);
            
            // Act
            sut.UpdateQuality();
            
            // Assert
            Assert.AreEqual("fixme", Items[0].Name);
        }
    }
}
