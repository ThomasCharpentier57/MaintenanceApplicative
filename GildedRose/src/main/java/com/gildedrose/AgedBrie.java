package com.gildedrose;

public class AgedBrie extends Item {

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (this.quality < 50) {
            this.quality++;
        }

        this.sellIn--;

        if(this.sellIn<0){
            if (this.quality < 50) {
                this.quality++;
            }
        }
    }
}
