package com.helpmeproductions.willus08.nychighschoolchalange.view.injection.school_information;


import com.helpmeproductions.willus08.nychighschoolchalange.view.activities.school_information.SchoolInformationPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class SchoolInformationModule {
    @Provides
    SchoolInformationPresenter schoolInformationPresenterProvider(){
        return new SchoolInformationPresenter();
    }
}
