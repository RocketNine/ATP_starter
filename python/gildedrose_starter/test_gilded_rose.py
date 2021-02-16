# -*- coding: utf-8 -*-
import unittest

from gilded_rose import Item, GildedRose


class GildedRoseTest(unittest.TestCase):
    def test_needs_a_better_name(self):
        # Arrange
        items = [Item("foo", 0, 0)]
        sut = GildedRose(items)

        # Act
        sut.update_quality()

        # Assert
        self.assertEquals("fixme", items[0].name)


if __name__ == '__main__':
    unittest.main()
