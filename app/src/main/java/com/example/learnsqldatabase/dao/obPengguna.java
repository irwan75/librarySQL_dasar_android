package com.example.learnsqldatabase.dao;

public class obPengguna {

    private int id;
    private String name;
    private String no_hp;

    public obPengguna(){

    }

    public obPengguna(int id, String name, String no_hp) {
        this.id = id;
        this.name = name;
        this.no_hp = no_hp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }
}
