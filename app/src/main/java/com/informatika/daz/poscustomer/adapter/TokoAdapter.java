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
import com.informatika.daz.poscustomer.model.Toko;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class TokoAdapter extends RecyclerView.Adapter<TokoAdapter.ViewHolder> {

    private List<Toko> tokoList;
    private OnItemClickListener mListener;
    private final Context context;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public TokoAdapter(Context context, List<Toko> tokoList) {
        this.context = context;
        this.tokoList = tokoList;
    }

    @NonNull
    @Override
    public TokoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_toko, parent, false);
        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TokoAdapter.ViewHolder holder, int position) {

        holder.tvNama.setText(tokoList.get(position).getNama());
        holder.tvKategori.setText(tokoList.get(position).getKategori());
        Glide.with(context)
                .load(tokoList.get(position).getFoto())
                .into(holder.ivFoto);
    }

    public void setTokoData(List<Toko> tokoList) {
        this.tokoList = tokoList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return tokoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView tvNama;
        final TextView tvKategori;
        final RoundedImageView ivFoto;

        ViewHolder(View itemView, final OnItemClickListener mListener) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNamaToko);
            tvKategori = itemView.findViewById(R.id.tvKategori);
            ivFoto = itemView.findViewById(R.id.ivToko);

            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = ViewHolder.this.getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        mListener.onItemClick(position);
                    }
                }
            });*/
        }
    }
}
