package vn.tiki.android.tikihome.model;

import java.io.Serializable;

public class Sale implements Serializable {
    private int imgSale;

    public Sale() {
    }

    public Sale(int imgSale) {
        this.imgSale = imgSale;
    }

    public int getImgSale() {
        return imgSale;
    }

    public void setImgSale(int imgSale) {
        this.imgSale = imgSale;
    }
}
