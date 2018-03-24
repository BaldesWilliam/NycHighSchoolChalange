package com.helpmeproductions.willus08.nychighschoolchalange.view.activities.school_information;


import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.helpmeproductions.willus08.nychighschoolchalange.R;
import com.helpmeproductions.willus08.nychighschoolchalange.model.HighSchoolInformation;

import java.util.ArrayList;
import java.util.List;

public class SchoolInformationAdapter extends RecyclerView.Adapter<SchoolInformationAdapter.ViewHolder> {
    private List<HighSchoolInformation> highSchoolInformationList = new ArrayList<>();

    SchoolInformationAdapter(List<HighSchoolInformation> highSchoolInformationList) {
        this.highSchoolInformationList = highSchoolInformationList;
    }

    @Override // this sets up the layout fr each of our items in the recycler view
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.school_info_items,parent,false);
        return new ViewHolder(view);
    }

    @Override // this will go through each schools information in the list and then display basic info
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final HighSchoolInformation info = highSchoolInformationList.get(position);
        String Address = info.getPrimaryAddressLine1() +
                " " + info.getCity() +
                " " + info.getStateCode() +
                " " + info.getZip();
        holder.name.setText(info.getSchoolName());
        holder.address.setText(Address);
        holder.website.setText(info.getWebsite());
        holder.email.setText(info.getSchoolEmail());

        // this will detect when the user clicks on an item so we can show them more details about it
        holder.itemContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=  new Intent("schoolInfo");
                intent.putExtra("info", info);
                holder.itemView.getContext().sendBroadcast(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return highSchoolInformationList.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout itemContainer;
        TextView name;
        TextView address;
        TextView website;
        TextView email;
         ViewHolder(View itemView) {
            super(itemView);
            itemContainer = itemView.findViewById(R.id.rlItemContainer);
            name  = itemView.findViewById(R.id.tvSchoolName);
            address = itemView.findViewById(R.id.tvSchoolAddress);
            website = itemView.findViewById(R.id.tvSchoolWebsite);
            email = itemView.findViewById(R.id.tvSchoolEmail);
        }
    }
}
