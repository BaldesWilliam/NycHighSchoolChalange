package com.helpmeproductions.willus08.nychighschoolchalange.view.injection.detailed_infortmation;


import com.helpmeproductions.willus08.nychighschoolchalange.view.activities.detailed_information.DetailedInformation;

import dagger.Component;

@Component(modules = DetailedInformationModule.class)
public interface DetailedInformationComponent {
    void inject(DetailedInformation detailedInformation);
}
