
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Student implements Serializable{

    private String email;
    private String name;
    private boolean sex;
    private int age;

    public Student() {
    }

    public Student(String email, String name, boolean sex, int age) {
        this.email = email;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public String getSex() {
        String sex1 = "FeMale";
        if (sex == true) {
            sex1 = "Male";
        }
        return sex1;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
