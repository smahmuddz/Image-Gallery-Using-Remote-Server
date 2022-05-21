package edu.ewubd.galleryapp;

public class arraylistOfImage {
    String imageID;
    String description;

    public arraylistOfImage(String imageID, String description) {
        this.imageID = imageID;
        this.description = description;
    }
    public arraylistOfImage(){}


    public String getimageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
