package com.helpmeproductions.willus08.nychighschoolchalange.view.activities.school_information;


import android.content.Context;
import android.content.Intent;

import com.helpmeproductions.willus08.nychighschoolchalange.model.HighSchoolInformation;
import com.helpmeproductions.willus08.nychighschoolchalange.view.activities.detailed_information.DetailedInformation;

public class SchoolInformationRouter implements SchoolInformationContract.Router{

    @Override
    public void goToDetailedInformation(Context context, HighSchoolInformation information) {
        Intent intent = new Intent(context,DetailedInformation.class);
        intent.putExtra("information", information);
        context.startActivity(intent);
    }
}
