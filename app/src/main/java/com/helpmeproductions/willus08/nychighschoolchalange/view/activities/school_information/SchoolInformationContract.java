package com.helpmeproductions.willus08.nychighschoolchalange.view.activities.school_information;


import android.content.Context;

import com.helpmeproductions.willus08.nychighschoolchalange.model.HighSchoolInformation;
import com.helpmeproductions.willus08.nychighschoolchalange.view.BasePresenter;
import com.helpmeproductions.willus08.nychighschoolchalange.view.BaseView;

import java.util.List;

public interface SchoolInformationContract {
    interface View extends BaseView{
        void setupAdapter(List<HighSchoolInformation> informationList);
    }

    interface Presenter extends BasePresenter<View>{
        void getHighSchoolInformation();
    }

    interface Router{
        void goToDetailedInformation(Context context, HighSchoolInformation information);
    }
}
