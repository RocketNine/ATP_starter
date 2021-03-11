using System.Collections.Generic;

namespace GildedRose
{
    public class GildedRose
    {
        private readonly IList<Item> _items;
        public IList<Item> Items => _items;

        public GildedRose(IList<Item> items)
        {
            this._items = items;
        }

        public void UpdateQuality()
        {
            for (var i = 0; i < _items.Count; i++)
            {
                if (!_items[i].Name.Equals("Aged Brie") && !_items[i].Name.Equals("Backstage passes to a TAFKAL80ETC concert"))
                {
                    if (_items[i].Quality > 0)
                    {
                        if (!_items[i].Name.Equals("Sulfuras, Hand of Ragnaros"))
                        {
                            _items[i].Quality = _items[i].Quality - 1;
                        }
                    }
                }
                else
                {
                    if (_items[i].Quality < 50)
                    {
                        _items[i].Quality = _items[i].Quality + 1;

                        if (_items[i].Name.Equals("Backstage passes to a TAFKAL80ETC concert"))
                        {
                            if (_items[i].SellIn < 11)
                            {
                                if (_items[i].Quality < 50)
                                {
                                    _items[i].Quality = _items[i].Quality + 1;
                                }
                            }

                            if (_items[i].SellIn < 6)
                            {
                                if (_items[i].Quality < 50)
                                {
                                    _items[i].Quality = _items[i].Quality + 1;
                                }
                            }
                        }
                    }
                }

                if (!_items[i].Name.Equals("Sulfuras, Hand of Ragnaros"))
                {
                    _items[i].SellIn = _items[i].SellIn - 1;
                }

                if (_items[i].SellIn < 0)
                {
                    if (!_items[i].Name.Equals("Aged Brie"))
                    {
                        if (!_items[i].Name.Equals("Backstage passes to a TAFKAL80ETC concert"))
                        {
                            if (_items[i].Quality > 0)
                            {
                                if (!_items[i].Name.Equals("Sulfuras, Hand of Ragnaros"))
                                {
                                    _items[i].Quality = _items[i].Quality - 1;
                                }
                            }
                        }
                        else
                        {
                            _items[i].Quality = _items[i].Quality - _items[i].Quality;
                        }
                    }
                    else
                    {
                        if (_items[i].Quality < 50)
                        {
                            _items[i].Quality = _items[i].Quality + 1;
                        }
                    }
                }
            }
        }
    }
}