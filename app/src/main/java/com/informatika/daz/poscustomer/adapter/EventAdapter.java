package com.informatika.daz.poscustomer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.informatika.daz.poscustomer.R;
import com.informatika.daz.poscustomer.model.Event;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    private List<Event> eventList;
    private OnItemClickListener mListener;
    private final Context context;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public EventAdapter(Context context, List<Event> eventList) {
        this.context = context;
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false);
        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull EventAdapter.ViewHolder holder, int position) {

        holder.tvNama.setText(eventList.get(position).getNama());
        holder.tvTanggal.setText(eventList.get(position).getTanggal());
        Glide.with(context)
                .load(eventList.get(position).getFoto())
                .into(holder.ivFoto);
    }

    public void setEventData(List<Event> eventList) {
        this.eventList = eventList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView tvNama;
        final TextView tvTanggal;
        final RoundedImageView ivFoto;

        ViewHolder(View itemView, final OnItemClickListener mListener) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNamaChallenge);
            tvTanggal = itemView.findViewById(R.id.tvTanggal);
            ivFoto = itemView.findViewById(R.id.ivChallenge);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = ViewHolder.this.getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        mListener.onItemClick(position);
                    }
                }
            });
        }
    }
}
