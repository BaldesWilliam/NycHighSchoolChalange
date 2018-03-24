package com.helpmeproductions.willus08.nychighschoolchalange.data.remote;





import com.helpmeproductions.willus08.nychighschoolchalange.model.HighSchoolInformation;
import com.helpmeproductions.willus08.nychighschoolchalange.model.HighSchoolSATInformation;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    @GET("resource/97mf-9njv.json")
    Call<List<HighSchoolInformation>> generalInformationCall();

    @GET("resource/734v-jeq5.json")
    Call<List<HighSchoolSATInformation>> satInformationCall(@Query("dbn") String dbn);
}
