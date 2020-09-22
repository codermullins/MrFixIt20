package net.androidbootcamp.mrfixit20.model;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.androidbootcamp.mrfixit20.R;

import java.util.ArrayList;

public class PartsAdapter extends RecyclerView.Adapter<PartsAdapter.PartsViewHolder> {
    private static final String TAG = "PartsAdapter";

    private ArrayList part_id, appSerialPart, partName, partNumber, partCost, partQty;
    private PartItemListener mPartItemListener;
    private Context mContext;

    public PartsAdapter(Context mContext, ArrayList partName, ArrayList partNumber, ArrayList partCost, ArrayList partQty, PartItemListener mPartItemListener) {
        this.mContext = mContext;
        this.part_id = part_id;
        this.appSerialPart = appSerialPart;
        this.partName = partName;
        this.partNumber = partNumber;
        this.partCost = partCost;
        this.partQty = partQty;
        this.mPartItemListener = mPartItemListener;

    }

    @NonNull
    @Override
    public PartsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: New view requested");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parts_row, parent, false);
        return new PartsViewHolder(view, mPartItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PartsAdapter.PartsViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called");

        holder.partNameText.setText(String.valueOf(partName.get(position)));
        holder.partNumberText.setText(String.valueOf(partNumber.get(position)));
        holder.partCostText.setText(String.valueOf(partCost.get(position)));
        holder.partInvText.setText(String.valueOf(partQty.get(position)));

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: called");
        return partNumber.size();
    }

    public static class PartsViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
        private static final String TAG = "ViewHolder";
        TextView partNameText;
        TextView partNumberText;
        TextView partCostText;
        TextView partInvText;
        View mView;
        PartItemListener partItemListener;


        public PartsViewHolder(@NonNull View itemView, PartItemListener partItemListener) {
            super(itemView);
            partNameText = (TextView) itemView.findViewById(R.id.partName);
            partNumberText = (TextView) itemView.findViewById(R.id.partNumber);
            partCostText = (TextView) itemView.findViewById(R.id.partCost);
            partInvText = (TextView) itemView.findViewById(R.id.partInv);
            this.partItemListener = partItemListener;

            mView = itemView;

            mView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            partItemListener.partItemClick(getAdapterPosition());
        }
    }

    public interface PartItemListener{
        void partItemClick(int position);
    }
}
