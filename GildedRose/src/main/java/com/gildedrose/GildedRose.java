package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name){
                case "Aged Brie":
                    handleBrie(item);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    handleBackstage(item);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    break;
                default:
                    handleLambda(item);
            }
        }
    }

    private void handleBrie(Item item){
        if (item.quality < 50) {
            item.quality++;
        }

        item.sellIn--;

        if(item.sellIn<0){
            if (item.quality < 50) {
                item.quality++;
            }
        }

    }

    private void handleBackstage(Item item) {
        if (item.quality < 50) {
            item.quality++;
            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality++;
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality++;
                }
            }
        }

        item.sellIn--;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void handleLambda(Item item) {

        if (item.quality > 0) {
            item.quality--;
        }

        if (item.sellIn < 0) {
            if (item.quality > 0) {
                    item.quality--;
            }
        }
        item.sellIn--;
    }

}
