package com.hfad.anlgsportal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Address implements Serializable {

    @SerializedName("address")
    @Expose
    private String address;

    public Address(String address) {
        this.address = address;
    }
}
