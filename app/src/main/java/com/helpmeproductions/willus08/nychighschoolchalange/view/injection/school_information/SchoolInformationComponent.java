package com.helpmeproductions.willus08.nychighschoolchalange.view.injection.school_information;

import com.helpmeproductions.willus08.nychighschoolchalange.view.activities.school_information.SchoolInformation;

import dagger.Component;

@Component(modules = SchoolInformationModule.class)
public interface SchoolInformationComponent {
    void inject(SchoolInformation schoolInformation);
}
