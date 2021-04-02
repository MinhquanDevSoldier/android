package com.example.quanlycauthu;

import java.io.Serializable;

public class CauThu implements Serializable {
    int id;
    String ten;
    int soao;
    String diachi;

    public CauThu(int ID,String ten, int soao, String diachi) {
        this.id = ID;
        this.ten = ten;
        this.soao = soao;
        this.diachi = diachi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSoao() {
        return soao;
    }

    public void setSoao(int soao) {
        this.soao = soao;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}
