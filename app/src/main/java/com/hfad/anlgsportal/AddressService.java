package com.hfad.anlgsportal;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AddressService {

    @GET("autocomplete?q={address} &fuzzy=")
    Call<List<Address>> getAllAddresses(@Path("address") String address);
}

