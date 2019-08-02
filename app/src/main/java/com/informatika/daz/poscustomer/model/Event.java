package com.informatika.daz.poscustomer.model;

public class Event {
    private Integer id;
    private String nama, deskripsi, tanggal, foto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Event(Integer id, String nama, String deskripsi, String tanggal, String foto) {
        this.id = id;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.tanggal = tanggal;
        this.foto = foto;
    }
}
