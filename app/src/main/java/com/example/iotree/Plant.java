package com.example.iotree;

public class Plant {
    private String l_name, b_name, price, image, known_hazards, soil, habitat;

    public Plant(String l_name, String b_name, String price, String image, String known_hazards, String soil, String habitat) {
        this.l_name = l_name;
        this.b_name = b_name;
        this.price = price;
        this.image = image;
        this.known_hazards = known_hazards;
        this.soil = soil;
        this.habitat = habitat;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getKnown_hazards() {
        return known_hazards;
    }

    public void setKnown_hazards(String known_hazards) {
        this.known_hazards = known_hazards;
    }

    public String getSoil() {
        return soil;
    }

    public void setSoil(String soil) {
        this.soil = soil;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }
}
