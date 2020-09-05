package net.androidbootcamp.mrfixit20.model;


import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.androidbootcamp.mrfixit20.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ApplianceAdapter extends RecyclerView.Adapter<ApplianceAdapter.ApplianceViewHolder>{
    private static final String TAG = "ApplianceAdapter";

    private ArrayList app_id, appMake, appModel, appSerial, appType;
    private Context mContext;

    public ApplianceAdapter(Context context, ArrayList appMake, ArrayList appModel, ArrayList appSerial, ArrayList appType) {
        this.mContext = mContext;
        this.app_id = app_id;
        this.appMake = appMake;
        this.appModel = appModel;
        this.appSerial = appSerial;
        this.appType = appType;
    }

    @NonNull
    @Override
    public ApplianceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: new view requested");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.appliance_row, parent, false);;
        return new ApplianceViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ApplianceViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        holder.makeText.setText(String.valueOf(appMake.get(position)));
        holder.modelText.setText(String.valueOf(appModel.get(position)));
        holder.serialText.setText(String.valueOf(appSerial.get(position)));
        holder.typeText.setText(String.valueOf(appType.get(position)));

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: called");
        return appMake.size();
    }



    public static class ApplianceViewHolder extends RecyclerView.ViewHolder {
        private static final String TAG = "ViewHolder";
        TextView makeText;
        TextView modelText;
        TextView serialText;
        TextView typeText;

        public ApplianceViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.d(TAG, "ViewHolder: Starts");
            makeText = (TextView) itemView.findViewById(R.id.appMake);
            modelText = (TextView) itemView.findViewById(R.id.appModel);
            serialText = (TextView) itemView.findViewById(R.id.appSerial);
            typeText = (TextView) itemView.findViewById(R.id.appType);
        }
    }
}
