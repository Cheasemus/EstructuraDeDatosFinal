package com.ipn.estructuradedatos;

public class LocationData
{
    private final String name;
    private final String address;
    private final String description;
    private final int image;

    public LocationData(String name, String address, String description, int image) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.image = image;
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

    public int getImage() {
        return image;
    }
}
