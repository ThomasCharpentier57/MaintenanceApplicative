package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void updateQuality(){
        if (this.quality > 0) {
            this.quality--;
        }

        if (this.sellIn < 0) {
            if (this.quality > 0) {
                this.quality--;
            }
        }
        this.sellIn--;
    }
}
