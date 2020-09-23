package com.hfad.anlgsportal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Address implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("status")
    @Expose
    private Installation status;
    @SerializedName("darstatus")
    @Expose
    private Installation darstatus;
    @SerializedName("vejkode")
    @Expose
    private String vejkode;
    @SerializedName("vejnavn")
    @Expose
    private String vejnavn;
    @SerializedName("adresseringsvejnavn")
    @Expose
    private String adresseringsvejnavn;
    @SerializedName("husnr")
    @Expose
    private String husnr;
    @SerializedName("etage")
    @Expose
    private Object etage;
    @SerializedName("d\u00f8r")
    @Expose
    private Object dR;
    @SerializedName("supplerendebynavn")
    @Expose
    private Object supplerendebynavn;
    @SerializedName("postnr")
    @Expose
    private String postnr;
    @SerializedName("postnrnavn")
    @Expose
    private String postnrnavn;
    @SerializedName("stormodtagerpostnr")
    @Expose
    private Object stormodtagerpostnr;
    @SerializedName("stormodtagerpostnrnavn")
    @Expose
    private Object stormodtagerpostnrnavn;
    @SerializedName("kommunekode")
    @Expose
    private String kommunekode;
    @SerializedName("adgangsadresseid")
    @Expose
    private String adgangsadresseid;
    @SerializedName("x")
    @Expose
    private Double x;
    @SerializedName("y")
    @Expose
    private Double y;
    @SerializedName("href")
    @Expose
    private String href;

    @SerializedName("tekst")
    @Expose
    private String tekst;

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Installation getStatus() {
        return status;
    }

    public void setStatus(Installation status) {
        this.status = status;
    }

    public Installation getDarstatus() {
        return darstatus;
    }

    public void setDarstatus(Installation darstatus) {
        this.darstatus = darstatus;
    }

    public String getVejkode() {
        return vejkode;
    }

    public void setVejkode(String vejkode) {
        this.vejkode = vejkode;
    }

    public String getVejnavn() {
        return vejnavn;
    }

    public void setVejnavn(String vejnavn) {
        this.vejnavn = vejnavn;
    }

    public String getAdresseringsvejnavn() {
        return adresseringsvejnavn;
    }

    public void setAdresseringsvejnavn(String adresseringsvejnavn) {
        this.adresseringsvejnavn = adresseringsvejnavn;
    }

    public String getHusnr() {
        return husnr;
    }

    public void setHusnr(String husnr) {
        this.husnr = husnr;
    }

    public Object getEtage() {
        return etage;
    }

    public void setEtage(Object etage) {
        this.etage = etage;
    }

    public Object getDR() {
        return dR;
    }

    public void setDR(Object dR) {
        this.dR = dR;
    }

    public Object getSupplerendebynavn() {
        return supplerendebynavn;
    }

    public void setSupplerendebynavn(Object supplerendebynavn) {
        this.supplerendebynavn = supplerendebynavn;
    }

    public String getPostnr() {
        return postnr;
    }

    public void setPostnr(String postnr) {
        this.postnr = postnr;
    }

    public String getPostnrnavn() {
        return postnrnavn;
    }

    public void setPostnrnavn(String postnrnavn) {
        this.postnrnavn = postnrnavn;
    }

    public Object getStormodtagerpostnr() {
        return stormodtagerpostnr;
    }

    public void setStormodtagerpostnr(Object stormodtagerpostnr) {
        this.stormodtagerpostnr = stormodtagerpostnr;
    }

    public Object getStormodtagerpostnrnavn() {
        return stormodtagerpostnrnavn;
    }

    public void setStormodtagerpostnrnavn(Object stormodtagerpostnrnavn) {
        this.stormodtagerpostnrnavn = stormodtagerpostnrnavn;
    }

    public String getKommunekode() {
        return kommunekode;
    }

    public void setKommunekode(String kommunekode) {
        this.kommunekode = kommunekode;
    }

    public String getAdgangsadresseid() {
        return adgangsadresseid;
    }

    public void setAdgangsadresseid(String adgangsadresseid) {
        this.adgangsadresseid = adgangsadresseid;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}

