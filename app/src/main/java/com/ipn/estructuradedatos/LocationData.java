package com.ipn.estructuradedatos;

public class LocationData
{
    private final String name;
    private final String address;
    private final String description;
    private final int imageH;
    private final int imageV;

    public LocationData(String name, String address, String description, int imageH, int imageV) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.imageH = imageH;
        this.imageV = imageV;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public int getImageH() {
        return imageH;
    }

    public int getImageV() {
        return imageV;
    }
}
