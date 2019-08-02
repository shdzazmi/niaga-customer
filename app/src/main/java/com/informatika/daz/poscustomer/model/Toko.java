package com.informatika.daz.poscustomer.model;

public class Toko {
    private String nama;
    private String kategori;
    private String foto;

    private Integer id, isFavorite;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Integer isFavorite) {
        this.isFavorite = isFavorite;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Toko(Integer id, String nama, String kategori, Integer isFavorite, String foto) {
        this.nama = nama;
        this.kategori = kategori;
        this.foto = foto;
        this.id = id;
        this.isFavorite = isFavorite;
    }
}