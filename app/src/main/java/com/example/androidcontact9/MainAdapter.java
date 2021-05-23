package com.example.androidcontact9;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private CallMe callMe;

    public void setCallMe(CallMe callMe) {
        this.callMe = callMe;
    }

    Activity activity;
    ArrayList<ContactModel> arrayList;


    public MainAdapter(Activity activity, ArrayList<ContactModel>  arrayList){
        this.activity= activity;
        this.arrayList= arrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent,false );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ContactModel model = arrayList.get(position);
        holder.tvName.setText(model.getName());
        holder.tvNumber.setText(model.getNumber());
        holder.bing(arrayList.get(position));



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvNumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvNumber = itemView.findViewById(R.id.tv_number);
        }

        private void bing(ContactModel model){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callMe.Callme(getAdapterPosition());
                }
            });
        }
    }
}


