package com.hfad.anlgsportal;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface AddressService {

    @GET("autocomplete")
    Call<List<Address>> getAllAddresses(@Query("q") String address);

    //?q= &fuzzy=
}

