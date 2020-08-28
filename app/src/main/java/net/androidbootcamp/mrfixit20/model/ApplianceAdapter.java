package net.androidbootcamp.mrfixit20.model;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.DialogTitle;
import androidx.recyclerview.widget.RecyclerView;

import net.androidbootcamp.mrfixit20.ListActivity;
import net.androidbootcamp.mrfixit20.PartListActivity;
import net.androidbootcamp.mrfixit20.R;
import net.androidbootcamp.mrfixit20.database.DBHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class ApplianceAdapter extends RecyclerView.Adapter<ApplianceAdapter.ApplianceViewHolder>{
    private static final String TAG = "ApplianceAdapter";
    private ArrayList<Appliance> applianceList;
    private Context mContext;


    public ApplianceAdapter(Context context, ArrayList<Appliance> applianceList) {
        this.applianceList = applianceList;
        this.mContext = mContext;

    }

    @NonNull
    @Override
    public ApplianceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: new view requested");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.appliance_row, parent, false);;
        return new ApplianceViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ApplianceViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        Appliance appliance = applianceList.get(position);
        Log.d(TAG, "onBindViewHolder: " + appliance.getSerial() + " --> " + position);

        holder.make.setText(appliance.getMake());
        holder.model.setText(appliance.getModel());
        holder.serial.setText(appliance.getSerial());
        holder.type.setText(appliance.getType());

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: called");
        return applianceList.size();
    }

    void loadNewData(ArrayList<Appliance> newAppliance){
        applianceList = newAppliance;
        notifyDataSetChanged();
    }

    public Appliance getAppliance(int position) {
        return applianceList.get(position);
    }


    public static class ApplianceViewHolder extends RecyclerView.ViewHolder {
        private static final String TAG = "ViewHolder";
        TextView make = null;
        TextView model = null;
        TextView serial = null;
        TextView type = null;

        public ApplianceViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.d(TAG, "ViewHolder: Starts");
            make = (TextView) itemView.findViewById(R.id.makeInput);
            model = (TextView) itemView.findViewById(R.id.modelInput);
            serial = (TextView) itemView.findViewById(R.id.serialInput);
            type = (TextView) itemView.findViewById(R.id.typeInput);
        }
    }
}
