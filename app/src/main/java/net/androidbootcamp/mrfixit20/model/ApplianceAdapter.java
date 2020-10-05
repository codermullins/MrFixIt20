package net.androidbootcamp.mrfixit20.model;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import net.androidbootcamp.mrfixit20.ListActivity;
import net.androidbootcamp.mrfixit20.PartListActivity;
import net.androidbootcamp.mrfixit20.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ApplianceAdapter extends RecyclerView.Adapter<ApplianceAdapter.ApplianceViewHolder>{
    private static final String TAG = "ApplianceAdapter";

    private ArrayList app_id, appMake, appModel, appSerial, appType;
    private ItemListener mItemListener;
    private Context mContext;

    public ApplianceAdapter(Context context, ArrayList appMake, ArrayList appModel, ArrayList appSerial, ArrayList appType, ItemListener itemListener) {
        this.mContext = mContext;
        this.app_id = app_id;
        this.appMake = appMake;
        this.appModel = appModel;
        this.appSerial = appSerial;
        this.appType = appType;
        this.mItemListener = itemListener;
    }

    @NonNull
    @Override
    public ApplianceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: new view requested");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.appliance_row, parent, false);
        return new ApplianceViewHolder(view, mItemListener);
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



    public static class ApplianceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private static final String TAG = "ViewHolder";
        TextView makeText;
        TextView modelText;
        TextView serialText;
        TextView typeText;
        View mView;
        ItemListener itemListener;

        public ApplianceViewHolder(@NonNull View itemView, ItemListener itemListener) {
            super(itemView);
            Log.d(TAG, "ViewHolder: Starts");
            makeText = (TextView) itemView.findViewById(R.id.appMake);
            modelText = (TextView) itemView.findViewById(R.id.appModel);
            serialText = (TextView) itemView.findViewById(R.id.appSerial);
            typeText = (TextView) itemView.findViewById(R.id.appType);
            this.itemListener = itemListener;

            mView = itemView;

            mView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            itemListener.itemClick(getAdapterPosition());
        }
    }

    public interface ItemListener{
        void itemClick(int position);
    }

}
