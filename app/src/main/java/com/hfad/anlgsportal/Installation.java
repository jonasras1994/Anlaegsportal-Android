package com.hfad.anlgsportal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Installation implements Serializable {

    @SerializedName("installationId")
    @Expose
    private java.lang.Integer installationId;
    @SerializedName("productType")
    @Expose
    private String productType;
    @SerializedName("make")
    @Expose
    private Object make;
    @SerializedName("model")
    @Expose
    private Object model;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("warrantyDate")
    @Expose
    private String warrantyDate;
    @SerializedName("responsible")
    @Expose
    private Object responsible;
    @SerializedName("comment")
    @Expose
    private Object comment;
    @SerializedName("registrationDate")
    @Expose
    private String registrationDate;
    @SerializedName("installationDate")
    @Expose
    private String installationDate;
    @SerializedName("lastReview")
    @Expose
    private String lastReview;
    @SerializedName("reviewFrequency")
    @Expose
    private java.lang.Integer reviewFrequency;
    @SerializedName("checklistId")
    @Expose
    private java.lang.Integer checklistId;
    @SerializedName("bbrId")
    @Expose
    private Object bbrId;
    @SerializedName("qrId")
    @Expose
    private Object qrId;
    @SerializedName("owner")
    @Expose
    private Object owner;

    public java.lang.Integer getInstallationId() {
        return installationId;
    }

    public void setInstallationId(java.lang.Integer installationId) {
        this.installationId = installationId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Object getMake() {
        return make;
    }

    public void setMake(Object make) {
        this.make = make;
    }

    public Object getModel() {
        return model;
    }

    public void setModel(Object model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getWarrantyDate() {
        return warrantyDate;
    }

    public void setWarrantyDate(String warrantyDate) {
        this.warrantyDate = warrantyDate;
    }

    public Object getResponsible() {
        return responsible;
    }

    public void setResponsible(Object responsible) {
        this.responsible = responsible;
    }

    public Object getComment() {
        return comment;
    }

    public void setComment(Object comment) {
        this.comment = comment;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getInstallationDate() {
        return installationDate;
    }

    public void setInstallationDate(String installationDate) {
        this.installationDate = installationDate;
    }

    public String getLastReview() {
        return lastReview;
    }

    public void setLastReview(String lastReview) {
        this.lastReview = lastReview;
    }

    public java.lang.Integer getReviewFrequency() {
        return reviewFrequency;
    }

    public void setReviewFrequency(java.lang.Integer reviewFrequency) {
        this.reviewFrequency = reviewFrequency;
    }

    public java.lang.Integer getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(java.lang.Integer checklistId) {
        this.checklistId = checklistId;
    }

    public Object getBbrId() {
        return bbrId;
    }

    public void setBbrId(Object bbrId) {
        this.bbrId = bbrId;
    }

    public Object getQrId() {
        return qrId;
    }

    public void setQrId(Object qrId) {
        this.qrId = qrId;
    }

    public Object getOwner() {
        return owner;
    }

    public void setOwner(Object owner) {
        this.owner = owner;
    }

}