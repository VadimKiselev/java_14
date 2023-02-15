package ru.netology.domain;

public class Smartphone extends Product {
    private String madeBy;

    public Smartphone(int id, String name, int price, String madeBy) {
        super(id, name, price);
        this.madeBy = madeBy;
    }
}
