package com.ypaz.exercise23.Configuration;

public class Photograh {
    //Variables
    private String id = "Id";
    private String photo = "photo";
    private String description = "description";

    public Photograh(String id, String photo, String description) {
        this.id = id;
        this.photo = photo;
        this.description = description;
    }

    public Photograh() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
