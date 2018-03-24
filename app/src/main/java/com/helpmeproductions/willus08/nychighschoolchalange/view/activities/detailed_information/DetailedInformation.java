package com.helpmeproductions.willus08.nychighschoolchalange.view.activities.detailed_information;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.helpmeproductions.willus08.nychighschoolchalange.R;
import com.helpmeproductions.willus08.nychighschoolchalange.model.HighSchoolInformation;
import com.helpmeproductions.willus08.nychighschoolchalange.model.HighSchoolSATInformation;
import com.helpmeproductions.willus08.nychighschoolchalange.view.injection.detailed_infortmation.DaggerDetailedInformationComponent;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailedInformation extends AppCompatActivity implements DetailedInformationContract.View{

    @Inject DetailedInformationPresenter presenter;


    @BindView(R.id.tvName)
    TextView name;
    @BindView(R.id.tvAddress)
    TextView address;
    @BindView(R.id.tvPhone)
    TextView phone;
    @BindView(R.id.tvEmail)
    TextView email;
    @BindView(R.id.tvWebsite)
    TextView website;

    @BindView(R.id.tvScoreHeader)
    TextView scoreHeader;
    @BindView(R.id.tvMathScore)
    TextView math;
    @BindView(R.id.tvReadingScore)
    TextView reading;
    @BindView(R.id.tvWritingScore)
    TextView writing;
    @BindView(R.id.tvOpportunity)
    TextView oportunity;
    @BindView(R.id.tvOverview)
    TextView overview;

    HighSchoolInformation schoolInformation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_information);
        ButterKnife.bind(this);
        setupDagger();
        schoolInformation = (HighSchoolInformation) getIntent().getSerializableExtra("information");
        presenter.getSATInformation(schoolInformation.getDbn());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.removeView();
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setupDagger() {
        DaggerDetailedInformationComponent.create().inject(this);
        presenter.addView(this);
    }

    @Override
    public void showInformation(List<HighSchoolSATInformation> info) {

        String Address = schoolInformation.getPrimaryAddressLine1() +
                " " + schoolInformation.getCity() +
                " " + schoolInformation.getStateCode() +
                " " + schoolInformation.getZip();


        String Opportunities = schoolInformation.getAcademicopportunities1()
                + " " + schoolInformation.getAcademicopportunities2();

        name.setText(schoolInformation.getSchoolName());
        phone.setText(schoolInformation.getPhoneNumber());
        email.setText(schoolInformation.getSchoolEmail());
        address.setText(Address);
        website.setText(schoolInformation.getWebsite());

        scoreHeader.setText(R.string.scores_header);


        String MathScore = "Math Scores: ";
        String ReadingScore = "Reading Scores: ";
        String WritingScore = "Writing Scores: ";
        // if the school has their SATS on record we will put their averages so the user can see
        if(info.size()>0) {
            MathScore += info.get(0).getSatMathAvgScore();
            WritingScore += info.get(0).getSatWritingAvgScore();
            ReadingScore += info.get(0).getSatCriticalReadingAvgScore();
        }else {  // incase there is no information on the sats for the school this will show that they are N/A
            MathScore += "N/A";
            WritingScore += "N/A";
            ReadingScore += "N/A";
        }
        math.setText(MathScore);
        writing.setText(WritingScore);
        reading.setText(ReadingScore);

        oportunity.setText(Opportunities);
        overview.setText(schoolInformation.getOverviewParagraph());
    }
}
