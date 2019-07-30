package com.mf.pradeg.DataModuls;

public class Servesitem {
    String name;
    String disc;
    String price;
    int icon;
    public Servesitem(){}

    public String getName() {
        return name;
    }

    public String getDisc() {
        return disc;
    }

    public String getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public void setPrice(String price) {
        this.price = price;
    }

//    public int getIcon() {
//        return icon;
//    }

//    public void setIcon(int icon) {
//        this.icon = icon;
//    }

    public Servesitem(String name, String disc, String price) {
        this.name = name;
        this.disc = disc;
        this.price = price;
//        this.icon=icon;
    }
}
