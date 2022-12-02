package com.example.project_app_thu_cung;

public class SanPham {
    private String name;
    private String mota;
    private String price;
    private String hinh;


    public SanPham() {
    }

    public SanPham(String name, String mota, String price, String hinh) {
        this.name = name;
        this.mota = mota;
        this.price = price;
        this.hinh = hinh;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }
}
