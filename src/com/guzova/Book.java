package com.guzova;

public class Book {
    private int number;
    private String name;
    private String author;
    private int count;
    private double price;

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getCount() {
        return count;
    }

    public double getPrice() {
        return price;
    }

    public Book(int number, String name, String author, int count, double price) {
        this.number = number;
        this.name = name;
        this.author = author;
        this.count = count;
        this.price = price;
    }

    @Override
    public String toString() {
        return "" + number + " " + name + " " + author + " " + count + " " + price;
    }
}
