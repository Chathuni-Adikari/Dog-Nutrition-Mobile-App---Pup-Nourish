package com.example.fooddogapp.model;

public class Product {

    private int id;
    private String name;
    private String brand;
    private String age;
    private double price;
    private String image;
    private int availability;

    public Product( int id, String name, String brand, String age, double price, String image, int availability) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.age = age;
        this.price = price;
        this.image = image;
        this.availability = availability;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand=" + brand +
                ", age='" + age + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", availability=" + availability +
                '}';
    }
}
