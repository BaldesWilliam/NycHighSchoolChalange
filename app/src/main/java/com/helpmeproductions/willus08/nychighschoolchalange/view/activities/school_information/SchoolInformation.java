package com.helpmeproductions.willus08.nychighschoolchalange.view.activities.school_information;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.helpmeproductions.willus08.nychighschoolchalange.R;
import com.helpmeproductions.willus08.nychighschoolchalange.model.HighSchoolInformation;
import com.helpmeproductions.willus08.nychighschoolchalange.view.injection.school_information.DaggerSchoolInformationComponent;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SchoolInformation extends AppCompatActivity implements SchoolInformationContract.View{

    @Inject SchoolInformationPresenter presenter;

    @BindView(R.id.rvSchoolItems)
    RecyclerView itemsView;

    SchoolInformationRouter router = new SchoolInformationRouter();
    SchoolInformationAdapter adapter;
    DefaultItemAnimator animator;
    RecyclerView.LayoutManager layoutManager;
    Receiver receiver = new Receiver();
    IntentFilter filter = new IntentFilter("schoolInfo");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_information);
        ButterKnife.bind(this);
        setupDagger();
        presenter.getHighSchoolInformation();
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(receiver,filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(receiver);
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
        DaggerSchoolInformationComponent.create().inject(this);
        presenter.addView(this);
    }

    @Override
    public void setupAdapter(List<HighSchoolInformation> informationList) {
        adapter = new SchoolInformationAdapter(informationList);
        layoutManager = new LinearLayoutManager(this);
        animator = new DefaultItemAnimator();

        itemsView.setAdapter(adapter);
        itemsView.setLayoutManager(layoutManager);
        itemsView.setItemAnimator(animator);
    }

    class Receiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            router.goToDetailedInformation(context, (HighSchoolInformation) intent.getSerializableExtra("info"));
        }
    }
}
