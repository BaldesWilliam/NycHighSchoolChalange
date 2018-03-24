package com.helpmeproductions.willus08.nychighschoolchalange.view.activities.detailed_information;


import android.support.annotation.NonNull;


import com.helpmeproductions.willus08.nychighschoolchalange.data.remote.APIProvider;
import com.helpmeproductions.willus08.nychighschoolchalange.model.HighSchoolSATInformation;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class DetailedInformationPresenter implements DetailedInformationContract.Presenter{
    private DetailedInformationContract.View view;

    @Override
    public void addView(DetailedInformationContract.View view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        this.view = null;
    }

    @Override
    public void getSATInformation(String dbn) {
        final retrofit2.Call<List<HighSchoolSATInformation>> satInformationCall = APIProvider.getSATInfoCall(dbn);
        satInformationCall.enqueue(new retrofit2.Callback<List<HighSchoolSATInformation>>() {
            @Override
            public void onResponse(@NonNull Call<List<HighSchoolSATInformation>> call, @NonNull Response<List<HighSchoolSATInformation>> response) {
                view.showInformation(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<HighSchoolSATInformation>> call, @NonNull Throwable t) {
                view.showMessage(t.getLocalizedMessage());
            }
        });
    }
}
