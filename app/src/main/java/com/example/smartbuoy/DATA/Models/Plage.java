package com.example.smartbuoy.DATA.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Plage {

    @SerializedName("detail")
    @Expose
    private Detail detail;
    @SerializedName("images")
    @Expose
    private List<Object> images = null;
    @SerializedName("buoys")
    @Expose
    private List<String> buoys = null;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("nom")
    @Expose
    private String nom;
    @SerializedName("ville")
    @Expose
    private String ville;
    @SerializedName("etat")
    @Expose
    private String etat;
    @SerializedName("capacite")
    @Expose
    private Integer capacite;
    @SerializedName("mainImage")
    @Expose
    private String mainImage;
    @SerializedName("rates")
    @Expose
    private List<Object> rates = null;
    @SerializedName("events")
    @Expose
    private List<Object> events = null;
    @SerializedName("__v")
    @Expose
    private Integer v;
    @SerializedName("meteo")
    @Expose
    private Meteo meteo;

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public List<Object> getImages() {
        return images;
    }

    public void setImages(List<Object> images) {
        this.images = images;
    }

    public List<String> getBuoys() {
        return buoys;
    }

    public void setBuoys(List<String> buoys) {
        this.buoys = buoys;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Integer getCapacite() {
        return capacite;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public List<Object> getRates() {
        return rates;
    }

    public void setRates(List<Object> rates) {
        this.rates = rates;
    }

    public List<Object> getEvents() {
        return events;
    }

    public void setEvents(List<Object> events) {
        this.events = events;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public Meteo getMeteo() {
        return meteo;
    }

    public void setMeteo(Meteo meteo) {
        this.meteo = meteo;
    }

}