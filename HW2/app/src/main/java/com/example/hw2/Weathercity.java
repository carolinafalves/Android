package com.example.hw2;

public class Weathercity {
    private String city;
    private int foto;

    public Weathercity() {
    }
    public Weathercity(String name, int foto) {
        this.city = name;
        this.foto = foto;
    }
    public String getName() {
        return city;
    }
    public void setName(String name) {
        this.city = name;
    }
    public int getFoto() {
        return foto;
    }
    public void setFoto(int foto) {
        this.foto = foto;
    }
}
