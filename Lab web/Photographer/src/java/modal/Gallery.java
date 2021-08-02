/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import dal.DAO;

/**
 *
 * @author User
 */
public class Gallery {
    private int id;
    private String name;
    private String title;
    private String description;    
    private Image img;
    public Gallery() {
    }

    public Gallery(int id, String title, String description, String name) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getImg() {
        return new DAO().top1ImageOfGallery(id);
    }

    public void setImg(Image img) {
        this.img = img;
    }
}
