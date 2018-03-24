package com.helpmeproductions.willus08.nychighschoolchalange.view.injection.detailed_infortmation;


import com.helpmeproductions.willus08.nychighschoolchalange.view.activities.detailed_information.DetailedInformationPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class DetailedInformationModule {
    @Provides
    DetailedInformationPresenter detailedInformationPresenterProvider(){
        return new DetailedInformationPresenter();
    }
}
