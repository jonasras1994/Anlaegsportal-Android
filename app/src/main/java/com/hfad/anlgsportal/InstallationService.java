package com.hfad.anlgsportal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InstallationService {
    @GET("installations")
    Call<List<Installation>> getAllInstallations();
}
