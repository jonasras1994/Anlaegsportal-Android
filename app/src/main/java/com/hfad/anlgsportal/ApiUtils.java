package com.hfad.anlgsportal;

import retrofit2.Retrofit;

class ApiUtils {

    private ApiUtils(){

    }

    private static String BASEURL = "https://dawa.aws.dk/adresser/";

    public static AddressService getAddressService(){
        return RetrofitClient.getClient(BASEURL).create(AddressService.class);
    }
}
