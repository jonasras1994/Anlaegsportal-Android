package com.hfad.anlgsportal;

import retrofit2.Retrofit;

class ApiUtils {

    private ApiUtils(){

    }

    private static String BASEURL = "https://dawa.aws.dk/adresser/";
    private static String INSTALLATION_URL = "https://lekondbrest.azurewebsites.net/api/";

    public static AddressService getAddressService(){
        return RetrofitClient.getClient(BASEURL).create(AddressService.class);
    }

    public static InstallationService getInstallationService(){
        return RetrofitClient.getClient(INSTALLATION_URL).create(InstallationService.class);
    }
}
