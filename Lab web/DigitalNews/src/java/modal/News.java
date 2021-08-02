/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author User
 */
public class News {

    private int id;
    private String title;
    private String content;
    private String writter;
    private Date date;
    private String summary;
    private String image;

    public News(int id, String title, String content, String writter, Date date, String summary, String image) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writter = writter;
        this.date = date;
        this.summary = summary;
        this.image = image;
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

    public String getContent() {
        return content;
    }

    public void setDescription(String content) {
        this.content = content;
    }

    public String getWritter() {
        return writter;
    }

    public void setWritter(String writter) {
        this.writter = writter;
    }

    public Date getDate() {
        return date;
    }

    public String getDate1() {
        SimpleDateFormat df = new SimpleDateFormat("MMM dd yyy-hh:mma");
        String date1 = df.format(date);
        return date1;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "News{" + "id=" + id + ", title=" + title + ", content=" + content + ", writter=" + writter + ", date=" + date + ", summary=" + summary + ", image=" + image + '}';
    }

}
