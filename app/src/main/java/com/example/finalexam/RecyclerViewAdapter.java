package com.example.finalexam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    List<Appointment> data;
    OnItemClickListener mlistener;


    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mlistener = listener;
    }

    public RecyclerViewAdapter(List<Appointment> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_appointment, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(v, mlistener);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Appointment currentAppointment = data.get(position);

        holder.appointTitle.setText(currentAppointment.getPatientName());
        holder.appointInfo.setText(currentAppointment.getHealthProblems());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView appointTitle,
                        appointInfo;

        public MyViewHolder(View itemView, final OnItemClickListener listener){
            super(itemView);
            appointTitle = itemView.findViewById(R.id.appointTitle);
            appointInfo = itemView.findViewById(R.id.appointInfo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }

                    }
                }
            });

        }
    }




}
