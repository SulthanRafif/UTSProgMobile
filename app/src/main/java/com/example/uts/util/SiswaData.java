package com.example.uts.util;

public class SiswaData {

    private String NIS;
    private String Nama;
    private String Alamat;
    private String Handphone;
    private String Keterangan;


    public SiswaData(String NIS, String Nama, String Alamat, String Handphone, String Keterangan) {
        this.NIS = NIS;
        this.Nama = Nama;
        this.Alamat = Alamat;
        this.Handphone = Handphone;
        this.Keterangan = Keterangan;
    }

    public String getNIS() {
        return NIS;
    }

    public String getNama() {
        return Nama;
    }

    public String getAlamat() {
        return Alamat;
    }

    public String getHandphone() {
        return Handphone;
    }

    public String getKeterangan() {
        return Keterangan;
    }
}
