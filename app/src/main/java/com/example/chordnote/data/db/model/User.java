package com.example.chordnote.data.db.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Unique;

@Entity(nameInDb = "users")
public class User {

    @Id(autoincrement = true)
    private Long id;

    @Expose
    @SerializedName("email")
    @Property(nameInDb = "email")
    @Unique
    private String email;

    @Expose
    @SerializedName("nickname")
    @Property(nameInDb = "userName")
    private String userName;

    @Expose
    @SerializedName("sex")
    @Property(nameInDb = "sex")
    private int sex;

    @Expose
    @SerializedName("birth_data")
    @Property(nameInDb = "birthDate")
    private String birthDate;

    @Expose
    @SerializedName("description")
    @Property(nameInDb = "description")
    private String description;

    @Expose
    @SerializedName("image")
    @Property(nameInDb = "user_img_url")
    private String imageUrl;


    @Generated(hash = 1461781515)
    public User(Long id, String email, String userName, int sex, String birthDate,
            String description, String imageUrl) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.sex = sex;
        this.birthDate = birthDate;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSex() {
        return this.sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }



}