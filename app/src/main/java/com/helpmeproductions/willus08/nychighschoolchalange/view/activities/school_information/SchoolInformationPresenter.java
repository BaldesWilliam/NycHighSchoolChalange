package com.helpmeproductions.willus08.nychighschoolchalange.view.activities.school_information;


import android.support.annotation.NonNull;

import com.helpmeproductions.willus08.nychighschoolchalange.data.remote.APIProvider;
import com.helpmeproductions.willus08.nychighschoolchalange.model.HighSchoolInformation;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class SchoolInformationPresenter implements SchoolInformationContract.Presenter {
    private SchoolInformationContract.View view;
    private List<HighSchoolInformation> highSchoolInformationList = new ArrayList<>();

    @Override
    public void addView(SchoolInformationContract.View view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        this.view = null;
    }

    @Override
    public void getHighSchoolInformation() {

        final retrofit2.Call<List<HighSchoolInformation>> highSchoolInformationCall = APIProvider.getHighShcolInfoCall();
        highSchoolInformationCall.enqueue(new retrofit2.Callback<List<HighSchoolInformation>>() {

            // on a succesfull call this will get the information so we can then setup the
            //recycler view
            @Override
            public void onResponse(@NonNull Call<List<HighSchoolInformation>> call,
                                   @NonNull Response<List<HighSchoolInformation>> response) {
               if(response.body() != null)
               {
                   highSchoolInformationList.addAll(response.body());
                    view.setupAdapter(highSchoolInformationList);
               }else
                   view.showMessage("Can not acquire school information");
            }

            @Override // if for any reason the call fails this will display the error to the user
            public void onFailure(@NonNull Call<List<HighSchoolInformation>> call, @NonNull Throwable t) {
                view.showMessage(t.getLocalizedMessage());
            }
        });



    }
}
