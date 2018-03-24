package com.helpmeproductions.willus08.nychighschoolchalange.data.remote;



import com.helpmeproductions.willus08.nychighschoolchalange.model.HighSchoolInformation;
import com.helpmeproductions.willus08.nychighschoolchalange.model.HighSchoolSATInformation;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIProvider {
    private static final String BASE_URL ="https://data.cityofnewyork.us/";

    private static Retrofit create(){

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static Call<List<HighSchoolInformation>> getHighShcolInfoCall(){
        Retrofit retrofit = create();
        APIService services = retrofit.create(APIService.class);
        return services.generalInformationCall();
    }

    public static Call<List<HighSchoolSATInformation>> getSATInfoCall(String dbn){
        Retrofit retrofit = create();
        APIService services = retrofit.create(APIService.class);
        return services.satInformationCall(dbn);
    }
}
