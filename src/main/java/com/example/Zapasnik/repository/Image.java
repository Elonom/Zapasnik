package com.example.Zapasnik.repository;

public enum Image {

    APPLE("https://i.ibb.co/6n8BhQw/001-apple.png",1),
    BROCCOLI("https://i.ibb.co/nCC6cGG/010-broccoli.png",2);

    private String imageUrl;
    private int imageNumber;

    Image(String imageUrl, int imageNumber) {
        this.imageUrl = imageUrl;
        this.imageNumber = imageNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getImageNumber() {
        return imageNumber;
    }

    public void setImageNumber(int imageNumber) {
        this.imageNumber = imageNumber;
    }
}
