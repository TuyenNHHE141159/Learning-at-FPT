/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author User
 */
public class Flower {

    private int id;
    private String name;
    private String image;
    private String description;
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public Flower(int id, String name, String image, String description) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Flower() {
    }

    public Flower(int id, String name, String image, String description, int quantity) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.quantity = quantity;
    }

  

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
