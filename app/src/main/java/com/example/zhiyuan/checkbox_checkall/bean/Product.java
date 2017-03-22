package com.example.zhiyuan.checkbox_checkall.bean;

/**
 * Created by zhiyuan on 17/3/22.
 */

public class Product {
    private String title;
    private int price;
    private int count;
    private boolean isChecked;

    public Product(String title, int price, int count) {
        this.title = title;
        this.price = price;
        this.count = count;
    }

    public Product() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
