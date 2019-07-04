package ru.mirea.model;

import javax.persistence.*;


@Entity
@Table(name = "item")
public class Item {

    @Id
    private Integer id;

    private String type;
    private String name;
    private double price;


    public Item() {}

    public Item(int id, int price, String name, String type) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.type = type;
    }



    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

}
