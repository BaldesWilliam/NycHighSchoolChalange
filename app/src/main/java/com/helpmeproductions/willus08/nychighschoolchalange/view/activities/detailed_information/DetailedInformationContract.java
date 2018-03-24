package com.helpmeproductions.willus08.nychighschoolchalange.view.activities.detailed_information;


import android.content.Context;

import com.helpmeproductions.willus08.nychighschoolchalange.model.HighSchoolSATInformation;
import com.helpmeproductions.willus08.nychighschoolchalange.view.BasePresenter;
import com.helpmeproductions.willus08.nychighschoolchalange.view.BaseView;

import java.util.List;

public interface DetailedInformationContract {
    interface View extends BaseView{
        void showInformation(List<HighSchoolSATInformation> info);
    }

    interface Presenter extends BasePresenter<View>{
        void getSATInformation(String dbn);
    }

    interface Router{
        void returnToList(Context context);
    }
}
