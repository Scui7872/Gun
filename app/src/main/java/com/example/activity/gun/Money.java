package com.example.activity.gun;

import java.io.Serializable;

public class Money implements Serializable {
    private String title;
    private String intro;
    private String price;
    private int icon;
    private int way;

    public Money(String title, String intro, String price, int icon, int way) {
        this.title = title;
        this.intro = intro;
        this.price = price;
        this.icon = icon;
        this.way = way;
    }

    @Override
    public String toString() {
        return "Money{" +
                "title='" + title + '\'' +
                ", intro='" + intro + '\'' +
                ", price='" + price + '\'' +
                ", icon=" + icon +
                ", way=" + way +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getWay() {
        return way;
    }

    public void setWay(int way) {
        this.way = way;
    }
}
